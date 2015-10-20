package com.athena.dolly.controller.web.datagridserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import com.athena.dolly.controller.web.machine.Machine;

@Entity
@Table(name = "datagrid_server")
public class DataGridServer {

	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "type")
	private String type;
	@OneToOne
	private Machine machine;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

}
