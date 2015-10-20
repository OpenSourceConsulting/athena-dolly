package com.athena.dolly.controller.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.ServiceResult.Status;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository appRepo;

	public ServiceResult add(String context_path, String war_path, String name,
			String version) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult edit(int appId, String context_path, String war_path,
			String name, String version) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult delete(int appId) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}
}
