package com.athena.dolly.controller.web.application;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import com.athena.dolly.controller.web.tomcat.instance.TomcatInstance;

@Entity
@Table(name = "application")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "context_path")
	private String contextPath;
	@Column(name = "deployed_date")
	private Date deployedDate;
	@Column(name = "version")
	private String version;
	@Column(name = "display_name")
	private String displayName;
	@Column(name = "war_path")
	private String warPath;
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	@Column(name = "last_stopped_date")
	private Date lastStoppedDate;
	@Column(name = "last_reloaded_date")
	private Date lastReloaddedDate;
	@Column(name = "last_started_date")
	private Date lastStartedDate;
	private int state;
	@ManyToOne
	TomcatInstance tomcat;

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public Date getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(Date deployedDate) {
		this.deployedDate = deployedDate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getWarPath() {
		return warPath;
	}

	public void setWarPath(String warPath) {
		this.warPath = warPath;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Date getLastStoppedDate() {
		return lastStoppedDate;
	}

	public void setLastStoppedDate(Date lastStoppedDate) {
		this.lastStoppedDate = lastStoppedDate;
	}

	public Date getLastReloaddedDate() {
		return lastReloaddedDate;
	}

	public void setLastReloaddedDate(Date lastReloaddedDate) {
		this.lastReloaddedDate = lastReloaddedDate;
	}

	public Date getLastStartedDate() {
		return lastStartedDate;
	}

	public void setLastStartedDate(Date lastStartedDate) {
		this.lastStartedDate = lastStartedDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}