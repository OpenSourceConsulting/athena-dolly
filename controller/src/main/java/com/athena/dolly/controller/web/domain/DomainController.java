package com.athena.dolly.controller.web.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.ServiceResult.Status;
import com.athena.dolly.controller.web.common.model.GridJsonResponse;
import com.athena.dolly.controller.web.common.model.SimpleJsonResponse;
import com.athena.dolly.controller.web.tomcat.instance.TomcatInstance;
import com.athena.dolly.controller.web.tomcat.instance.TomcatInstanceService;

@Controller
@RequestMapping("/domain")
public class DomainController {

	@Autowired
	private DomainService domainService;
	@Autowired
	private TomcatInstanceService tomcatService;

	@RequestMapping("/list")
	public @ResponseBody
	List<Domain> getDomainList() {
		ServiceResult result = domainService.retrieve();
		if (result.getStatus() == Status.DONE) {
			List<Domain> domains = (List<Domain>) result.getReturnedVal();
			return domains;
			// / res.setData("Hello");
		}
		// return res;
		return null;
	}

	@RequestMapping("/tomcatlist")
	public @ResponseBody
	List<TomcatInstance> getTomcatInstanceByDomain(int domainId) {
		ServiceResult result = tomcatService.getTomcatListByDomainId(domainId);
		if (result.getStatus() == Status.DONE) {
			List<TomcatInstance> tomcats = (List<TomcatInstance>) result
					.getReturnedVal();
			return tomcats;
		}
		return null;
	}
}
