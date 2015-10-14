package com.athena.dolly.controller.web.machine;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athena.dolly.controller.common.SSHManager;

@Controller
@RequestMapping("/machine")
public class MachineController implements InitializingBean {

	@Autowired
	private MachineService service;

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		String mName = "Example";// retrive from form
		String ip4Addr = "192.168.0.88";// retrieve from form;
		String sshUserName = "root";// retrieve from form;
		String sshPasword = "test123";// retrieve from form;
		String desciprtion = "";
		Machine m = new Machine(mName, ip4Addr, sshUserName, sshPasword, desciprtion);

		return service.add(m);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// System.err.println("service : " + service);
	}
}
