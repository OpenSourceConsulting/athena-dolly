package com.athena.dolly.controller.web.machine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Disk drive object
 * 
 * @author hptra
 * 
 */
@Entity
public class Disk {

	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "capacity")
	private double capacity;
	@Column(name = "unit")
	private String unit; // MB, GB
	@Column(name = "file_system")
	private String file_system;
	@Column(name = "free_capacity")
	private double free_capacity;

	public double getFreeCapacity() {
		return free_capacity;
	}

	public void setFreeCapacity(double free_capacity) {
		this.free_capacity = free_capacity;
	}

	public String getFileSystem() {
		return file_system;
	}

	public void setFileSystem(String file_system) {
		this.file_system = file_system;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
