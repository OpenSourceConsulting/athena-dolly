package com.athena.dolly.controller.web.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.ServiceResult.Status;

@Service
public class DomainService {
	@Autowired
	private DomainRepository domainRepo;

	public ServiceResult add(String name, boolean is_clusering) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult edit(int domainId, String name, boolean is_clustering) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult delete(int domainId) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult configure(int domainId) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

}
