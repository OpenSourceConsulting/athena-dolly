package com.athena.dolly.controller.web.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.ServiceResult;
import com.athena.dolly.controller.ServiceResult.Status;

@Service
public class DatasourceService {
	@Autowired
	private DatasourceRepository datasourceRepo;

	public ServiceResult add() {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult edit(int datasource_id) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}

	public ServiceResult delete(int datasource_id) {
		return new ServiceResult(Status.DONE, "Not implemented yet");
	}
}
