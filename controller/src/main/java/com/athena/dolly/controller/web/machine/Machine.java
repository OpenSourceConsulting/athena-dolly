package com.athena.dolly.controller.web.machine;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represent the machine information
 * 
 * @author Tran Ho
 */
@Entity
@Table(name = "machine")
public class Machine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Id")
	private int Id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "ipv4_address")
	private String ipv4;
	@Column(name = "ipv6_address")
	private String ipv6;
	@Column(name = "host_name")
	private String host_name;
	@Column(name = "mac_address", nullable = false)
	private String mac_address;
	@Column(name = "os_name", nullable = false)
	private String os_name;
	@Column(name = "os_version", nullable = false)
	private String os_version;
	@Column(name = "cpu_clock_speed", nullable = false)
	private float cpu_clock_speed;
	@Column(name = "cpu_clock_unit", nullable = false)
	private String cpu_clock_unit;
	@Column(name = "memory_size", nullable = false)
	private float memory_size;
	@Column(name = "memory_unit", nullable = false)
	private String memory_unit;
	@Column(name = "cpu_core", nullable = false)
	private int cpu_core;
	@Column(name = "os_arch", nullable = false)
	private String os_arch;
	@Column(name = "origin_date", nullable = false)
	private Date origin_date;
	@Column(name = "last_shutdown")
	private Date last_shutdown;
	@Column(name = "description")
	private String description;
	@Column(name = "disk_size")
	private float disk_size;
	@Column(name = "disk_unit")
	private String disk_unit;
	@Column(name = "ssh_port")
	private int ssh_port;
	@Column(name = "ssh_username")
	private String ssh_username;
	@Column(name = "ssh_password")
	private String ssh_password;
	@Column(name = "is_vm")
	private boolean is_vm;
	@Column(name = "jvm")
	private String jvm_version;
	private int state;

	@OneToMany
	private Collection<Disk> disks;

	@OneToMany
	private Collection<Memory> memories;

	@OneToMany
	private Collection<NetworkInterface> network_interfaces;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getIpv6() {
		return ipv6;
	}

	public void setIpv6(String ipv6) {
		this.ipv6 = ipv6;
	}

	public String getHostName() {
		return host_name;
	}

	public void setHostName(String host_name) {
		this.host_name = host_name;
	}

	public String getMacAddress() {
		return mac_address;
	}

	public void setMacAddress(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getOsName() {
		return os_name;
	}

	public void setOsName(String os_name) {
		this.os_name = os_name;
	}

	public String getOsVersion() {
		return os_version;
	}

	public void setOsVersion(String os_version) {
		this.os_version = os_version;
	}

	public float getCpuClockSpeed() {
		return cpu_clock_speed;
	}

	public void setCpuClockSpeed(float cpu_clock_speed) {
		this.cpu_clock_speed = cpu_clock_speed;
	}

	public String getCpuClockUnit() {
		return cpu_clock_unit;
	}

	public void setCpuClockUnit(String cpu_clock_unit) {
		this.cpu_clock_unit = cpu_clock_unit;
	}

	public float getMemorySize() {
		return memory_size;
	}

	public void setMemorySize(float memory_size) {
		this.memory_size = memory_size;
	}

	public String getMemoryUnit() {
		return memory_unit;
	}

	public void setMemoryUnit(String memory_unit) {
		this.memory_unit = memory_unit;
	}

	public int getCpuCore() {
		return cpu_core;
	}

	public void setCpuCore(int cpu_core) {
		this.cpu_core = cpu_core;
	}

	public String getOsArch() {
		return os_arch;
	}

	public void setOsArch(String os_arch) {
		this.os_arch = os_arch;
	}

	public Date getOriginDate() {
		return origin_date;
	}

	public void setOriginDate(Date origin_date) {
		this.origin_date = origin_date;
	}

	public Date getLastShutdown() {
		return last_shutdown;
	}

	public void setLastShutdown(Date last_shutdown) {
		this.last_shutdown = last_shutdown;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDiskSize() {
		return disk_size;
	}

	public void setDiskSize(float disk_size) {
		this.disk_size = disk_size;
	}

	public String getDiskUnit() {
		return disk_unit;
	}

	public void setDiskUnit(String disk_unit) {
		this.disk_unit = disk_unit;
	}

	public int getSshPort() {
		return ssh_port;
	}

	public void setSshPort(int ssh_port) {
		this.ssh_port = ssh_port;
	}

	public String getSshUsername() {
		return ssh_username;
	}

	public void setSshUsername(String ssh_username) {
		this.ssh_username = ssh_username;
	}

	public String getSshPassword() {
		return ssh_password;
	}

	public void setSshPassword(String ssh_password) {
		this.ssh_password = ssh_password;
	}

	public String getJvmVersion() {
		return jvm_version;
	}

	public void setJvmVersion(String jvm_version) {
		this.jvm_version = jvm_version;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Constructor
	 */
	public Machine(String mHostName, String mip4_addr, String mSSHUserName,
			String mSSHPassword) {
		host_name = mHostName;
		ipv4 = mip4_addr;
		ssh_username = mSSHUserName;
		ssh_password = mSSHPassword;
	}

	public Machine() {
	}

	public Collection<Disk> getDisks() {
		return disks;
	}

	public void setDisks(Collection<Disk> disks) {
		this.disks = disks;
	}

	// memory
	public boolean addMemory(Memory m) {
		if (memories != null) {
			return memories.add(m);
		}
		return false;
	}

	public boolean removeMemory(Memory m) {
		if (memories != null) {
			return memories.remove(m);
		}
		return false;
	}

	// network interfaces
	public boolean addNetworkInterface(NetworkInterface ni) {
		if (network_interfaces != null) {
			return network_interfaces.add(ni);
		}
		return false;
	}

	public boolean removeNetworkInterface(NetworkInterface ni) {
		if (network_interfaces != null) {
			return network_interfaces.remove(ni);
		}
		return false;
	}

	// network interfaces
	public boolean addDisk(Disk d) {
		if (disks != null) {
			return disks.add(d);
		}
		return false;
	}

	public boolean removeDisk(Disk d) {
		if (disks != null) {
			return disks.remove(d);
		}
		return false;
	}

}
