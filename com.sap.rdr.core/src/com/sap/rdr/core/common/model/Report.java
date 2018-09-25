package com.sap.rdr.core.common.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
public class Report implements Serializable {

	@Id
	private String id;
	
	private String title;
	private String reporterName;
	private String source;
	private String content;
	private Date postDate;
	
	@Column(name="reporterId", nullable=true, length=50,
	        updatable=false, insertable=false)
	private String reporterId;
	
    @ManyToOne
    @JoinColumn(name="reporterId", nullable=true)
	private AppUser reporter;
	
	private static final long serialVersionUID = 1L;

	public Report() {
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

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
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
		return "Report [id=" + id + ", title=" + title + "]";
	}

}
