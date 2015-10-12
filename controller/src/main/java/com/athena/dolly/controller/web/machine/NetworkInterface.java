package com.athena.dolly.controller.web.machine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "network_interface")
public class NetworkInterface {

	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "ipv4")
	private String ipv4;
	@Column(name = "ipv6")
	private String ipv6;
	@Column(name = "default_gateway")
	private String default_gateway;
	@Column(name = "netmask")
	private String netmask;

	public String getNetmask() {
		return netmask;
	}

	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	public String getDefaultGateway() {
		return default_gateway;
	}

	public void setDefaultGateway(String defaultGateway) {
		this.default_gateway = defaultGateway;
	}

	public String getIpv6() {
		return ipv6;
	}

	public void setIpv6(String ipv6) {
		this.ipv6 = ipv6;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
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
