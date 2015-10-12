package com.athena.dolly.controller.web.machine;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.DollyConstants;
import com.athena.dolly.controller.common.SSHManager;

@Service
public class MachineService implements InitializingBean {

	@Autowired
	private MachineRepository repo;

	public MachineService() {

	}

	public String add(Machine m) {
		String sshCommand = "ls";
		String sshOutput = "";
		String ip4Addr = m.getIpv4().trim();
		String sshUserName = m.getSshUsername();
		String sshPassword = m.getSshPassword();

		// test connection
		String sshAddr = ip4Addr.equals("") ? DollyConstants.DEFAULT_IPv4
				: ip4Addr;
		SSHManager sshMng = new SSHManager(sshUserName, sshPassword, sshAddr);
		if (sshMng.connect() != null) {
			return "Cannot connect to machine \"" + sshAddr + "\"";
		}
		// parse machine information
		// get hostname info
		sshCommand = "hostname";
		sshOutput = sshMng.sendCommand(sshCommand);
		String hostname = sshOutput;
		// get os name and version
		sshCommand = "lsb_release -a";
		sshOutput = sshMng.sendCommand(sshCommand);
		// extract information

		// repo.save(m);
		return sshOutput;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("=====================================");
		System.err.println("=====================================");
		System.err.println("=====================================");
		System.err.println("repo : " + repo);
		System.err.println("=====================================");
		System.err.println("=====================================");
		System.err.println("=====================================");
	}
}
