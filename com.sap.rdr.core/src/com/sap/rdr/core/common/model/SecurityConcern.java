package com.sap.rdr.core.common.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class SecurityConcern implements Serializable {

	@Id
	private String id;
	
	private String type;
	private String content;
	private Double latitude;
	private Double longitude;
	
	@Column(name="assessmentId", nullable=true, length=50,
	        updatable=false, insertable=false)
	private String assessmentId;
	
    @ManyToOne
    @JoinColumn(name="assessmentId", nullable=true)
	private Assessment assessment;
    
	private static final long serialVersionUID = 1L;

	public SecurityConcern() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	@Override
	public String toString() {
		return "SecurityConcern [id=" + id + ", type=" + type + "]";
	}

}
