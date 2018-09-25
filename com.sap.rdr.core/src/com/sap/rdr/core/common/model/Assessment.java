package com.sap.rdr.core.common.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Assessment implements Serializable {

	@Id
	private String id;
	
	private String title;
	private String description;
	private String content;
	private String cluster;
	private Date postDate;
	private Double longitude;
	private Double latitude;
	
	@Column(name="reporterId", nullable=true, length=50,
	        updatable=false, insertable=false)
	private String reporterId;
	
    @ManyToOne
    @JoinColumn(name="reporterId", nullable=true)
	private AppUser reporter;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	private List<Need> needs;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	private List<Attachment> attachments;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	private List<Damage> damages;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	private List<SafetyConcern> safetyConcerns;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="assessment")
	private List<SecurityConcern> securityConcerns;
    
	private static final long serialVersionUID = 1L;

	public Assessment() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public List<Need> getNeeds() {
		return needs;
	}

	public void setNeeds(List<Need> needs) {
		this.needs = needs;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public List<Damage> getDamages() {
		return damages;
	}

	public void setDamages(List<Damage> damages) {
		this.damages = damages;
	}

	public List<SafetyConcern> getSafetyConcerns() {
		return safetyConcerns;
	}

	public void setSafetyConcerns(List<SafetyConcern> safetyConcerns) {
		this.safetyConcerns = safetyConcerns;
	}

	public List<SecurityConcern> getSecurityConcerns() {
		return securityConcerns;
	}

	public void setSecurityConcerns(List<SecurityConcern> securityConcerns) {
		this.securityConcerns = securityConcerns;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}
	
	public AppUser getReporter() {
		return reporter;
	}

	public void setReporter(AppUser reporter) {
		this.reporter = reporter;
	}
	
	@Override
	public String toString() {
		return "Assessment [id=" + id + ", title=" + title + "]";
	}

}
