package com.sap.rdr.core.common.context;

import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.rdr.core.common.util.SpringContextUtil;

public class JPAServiceFactory extends ODataJPAServiceFactory {

	private static final String PERSISTENT_UNIT = "RDR";
	private static final String EMF = "entityManagerFactory";

	private static final Logger LOG = LoggerFactory.getLogger(JPAServiceFactory.class);

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext oDataJPACtx = getODataJPAContext();
		EntityManagerFactory emf = (EntityManagerFactory) SpringContextUtil.getBean(EMF);
		LOG.debug("EMF in JPAservicefactory " + emf);
		oDataJPACtx.setEntityManagerFactory(emf);
		oDataJPACtx.setPersistenceUnitName(PERSISTENT_UNIT);
		oDataJPACtx.setDefaultNaming(true);
		this.setDetailErrors(true);
		return oDataJPACtx;
	}

}
