package com.sap.rdr.core.common.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Attachment implements Serializable {

	@Id
	private String id;
	
	private String name;
	private String mimeType;
	private String path;
	
	@Column(name="assessmentId", nullable=true, length=50,
	        updatable=false, insertable=false)
	private String assessmentId;
	
    @ManyToOne
    @JoinColumn(name="assessmentId", nullable=true)
	private Assessment assessment;
    
	private static final long serialVersionUID = 1L;

	public Attachment() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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
		return "Attachment [id=" + id + ", name=" + name + "]";
	}

}
