package com.athena.dolly.controller.web.machine;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athena.dolly.controller.DollyConstants;
import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.common.SSHManager;
import com.athena.dolly.controller.web.common.model.ExtjsGridParam;
import com.athena.dolly.controller.web.common.model.GridJsonResponse;

@Controller
@RequestMapping("/machine")
// public class MachineController implements InitializingBean {
public class MachineController {
	@Autowired
	private MachineService service;

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		String mName = "Example";// retrive from form
		String ip4Addr = "192.168.0.88";// retrieve from form;
		String sshUserName = "root";// retrieve from form;
		String sshPassword = "test123";// retrieve from form;
		int sshPort = DollyConstants.DEFAULT_SSH_PORT;
		String desciprtion = "";
		ServiceResult status = service.add(mName, desciprtion, ip4Addr,
				sshPort, sshUserName, sshPassword);
		return status.getMessage();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public GridJsonResponse getList(GridJsonResponse res,
			ExtjsGridParam gridParam) {
		Page<Machine> machines = (Page<Machine>) service.retrieve(1, 10)
				.getReturnedVal();
		res.setTotal(machines.getNumber());
		res.setList(machines.getContent());
		return res;
	}
	// for testing bean creation
	// @Override
	// public void afterPropertiesSet() throws Exception {
	// // System.err.println("service : " + service);
	// }
}
