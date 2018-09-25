package com.sap.rdr.core.common.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class AppUser implements Serializable {

	@Id
	private String id;
	
	private String firstname;
	private String lastname;
	
    @OneToMany(cascade=CascadeType.ALL, mappedBy="reporter")
	private List<Report> reports;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="reporter")
	private List<Assessment> assessments;

	private static final long serialVersionUID = 1L;

	public AppUser() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public List<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(List<Assessment> assessments) {
		this.assessments = assessments;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + firstname + " " + lastname + "]";
	}

}
