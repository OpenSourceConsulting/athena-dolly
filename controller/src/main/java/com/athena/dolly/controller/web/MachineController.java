package com.athena.dolly.controller.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athena.dolly.controller.domain.dto.Machine;
import com.athena.dolly.controller.services.MachineService;

@Controller
public class MachineController implements InitializingBean {

	@Autowired
	private MachineService service;

	@RequestMapping("/machine/test/")
	@ResponseBody
	public String test() {
		Machine m = new Machine();
		m.setName("Centos test");
		m.setDescription("This is a test");
		service.save(m);
		return "done test";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// System.err.println("service : " + service);
	}
}
