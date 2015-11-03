package com.athena.dolly.controller.web.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * A domain is used for grouping one or more tomcat instance. It is associated
 * to domain table in database
 * 
 * @author Tran Ho
 * 
 */
@Entity
@Table(name = "domain")
public class Domain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "is_clustering")
	private boolean isClustering;
	//@OneToOne
	//private DataGridServerGroup serverGroup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public boolean isClustering() {
		return isClustering;
	}

	public void setClustering(boolean isClustering) {
		this.isClustering = isClustering;
	}
}
