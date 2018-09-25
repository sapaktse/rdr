package com.sap.rdr.core.config;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

/**
 * The configuration class for beans required by the application.
 * 
 * @author i324363
 *
 */

@Configuration
@Profile("dev")
@ComponentScan(basePackages = {
		"com.sap.rdr.core.common",
		"com.sap.rdr.core.local"})
public class LocalConfig {

	private static final String DB_SVC = "jdbc/TestDB";

	private static final Logger LOG = LoggerFactory.getLogger(LocalConfig.class);

	/**
	 * Create dataSource bean from SAP CF
	 * 
	 * @return dataSource dataSoruce created from HANA Service.
	 */
	public DataSource dataSource() {
		DataSource dataSource = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup(DB_SVC);
		} catch (NamingException ex) {
			LOG.error(" ", ex);
		}
		return dataSource;
	}

	/**
	 * Create Eclipselink EMF from the dataSource bean. JPAvendor and datasource
	 * will be set here. rest will be taken from persistence.xml
	 * 
	 * @return EntityManagerFactory
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean springEMF = new LocalContainerEntityManagerFactoryBean();
		springEMF.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		springEMF.setDataSource(dataSource());
		springEMF.afterPropertiesSet();
		return springEMF.getObject();

	}

	/**
	 * Registers OData servlet bean with Spring Application context to handle
	 * ODataRequests.
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean odataServlet() {

		ServletRegistrationBean odataServRegstration = new ServletRegistrationBean(new CXFNonSpringJaxrsServlet(),
				"/odata.svc/*");
		Map<String, String> initParameters = new HashMap<>();
		initParameters.put("javax.ws.rs.Application", "org.apache.olingo.odata2.core.rest.app.ODataApplication");
		initParameters.put("org.apache.olingo.odata2.service.factory",
				"com.sap.rdr.core.common.context.JPAServiceFactory");
		odataServRegstration.setInitParameters(initParameters);

		return odataServRegstration;

	}

}
