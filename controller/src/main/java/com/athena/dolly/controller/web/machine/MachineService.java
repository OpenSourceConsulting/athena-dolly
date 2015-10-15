package com.athena.dolly.controller.web.machine;

import java.util.List;

import org.omg.CORBA.OMGVMCID;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.DollyConstants;
import com.athena.dolly.controller.ServiceStatus;
import com.athena.dolly.controller.ServiceStatus.Status;
import com.athena.dolly.controller.common.SSHManager;

/**
 * This is an service that is used for processing machine information
 * 
 * @author Tran Ho
 */

@Service
// public class MachineService implements InitializingBean {
public class MachineService {
	@Autowired
	private MachineRepository repo;

	public MachineService() {

	}

	public ServiceStatus add(Machine m) {
		String sshCommand = "ls";
		String sshOutput = "";
		String sshAddr = m.getSSHIPAddr();
		String sshUserName = m.getSshUsername();
		String sshPassword = m.getSshPassword();
		// check existing
		List<Machine> existingMachines = repo.findByNameOrSshIPAddr(
				m.getName(), sshAddr);
		if (existingMachines != null) {
			if (existingMachines.size() > 0) {
				return new ServiceStatus(Status.FAILED, "Duplicate machine");
			}
		}

		// test connection
		SSHManager sshMng = new SSHManager(sshUserName, sshPassword, sshAddr);
		if (sshMng.connect() != null) {
			return new ServiceStatus(Status.FAILED, "SSH Connection is failed.");
		}
		try {
			// parse machine information
			// get hostname info
			sshCommand = "hostname";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setHostName(sshOutput);
			// get os name and version
			sshCommand = "lsb_release -i | sed -e 's/^[a-z A-Z]*://'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setOsName(sshOutput);

			sshCommand = "lsb_release -r | sed -e 's/^[a-z A-Z]*://'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setOsVersion(sshOutput);
			// get number of cpu
			sshCommand = "nproc";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setCpuCore(Integer.parseInt(sshOutput));
			// get cpu speed
			sshCommand = "lscpu | grep 'CPU MHz' | sed -e 's/^[a-z A-Z :]*//'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setCpuClockSpeed(Float.parseFloat(sshOutput));
			// cpu clock measurement unit
			m.setCpuClockUnit(DollyConstants.DEFAULT_CPU_MEASUREMENT_UNIT);
			// total memory
			sshCommand = "cat /proc/meminfo | grep 'MemTotal' | sed -e 's/^[a-z A-Z]*://' -e 's/[a-z A-Z]*$//'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setMemorySize(Float.parseFloat(sshOutput));
			// memory measurement unit
			sshCommand = "cat /proc/meminfo | grep 'MemTotal' | sed -e 's/^[a-z A-Z: 0-9]*[ ]//'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setMemoryUnit(sshOutput);
			// OS architecture
			sshCommand = "arch";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.setOsArch(sshOutput);
			// check whether it is VM or not.

			sshCommand = "virt-what";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			m.isVM(sshOutput.equals("") ? false : true);

			// check java version
			sshCommand = "java -version 2>&1 | grep version | sed -e 's/java version \"//' -e 's/.$//'";
			sshOutput = sshMng.sendCommand(sshCommand).trim();
			// get network interfaces info
			// sshCommand =
			// "ifconfig | sed  -e 's/[ ].*HWaddr/|/' -e 's/inet addr:/|/' -e 's/Bcast:.*Mask:/|/' -e 's/inet6 addr: /|/' -e 's/Scope:.*/|/'";
			// sshOutput = sshMng.sendCommand(sshCommand);
			// extract information

			repo.save(m);
		} catch (Exception e) {
			return new ServiceStatus(Status.ERROR, e.getMessage());
		}
		return new ServiceStatus(Status.DONE, "Machine is added.");
	}

	// for testing bean creation
	// @Override
	// public void afterPropertiesSet() throws Exception {
	// System.err.println("=====================================");
	// System.err.println("=====================================");
	// System.err.println("=====================================");
	// System.err.println("repo : " + repo);
	// System.err.println("=====================================");
	// System.err.println("=====================================");
	// System.err.println("=====================================");
	// }
}
