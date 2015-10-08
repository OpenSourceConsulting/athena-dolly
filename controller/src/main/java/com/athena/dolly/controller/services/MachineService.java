package com.athena.dolly.controller.services;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athena.dolly.controller.domain.dto.Machine;
import com.athena.dolly.controller.domain.repositories.MachineRepository;

@Service
public class MachineService implements InitializingBean {

	@Autowired
	private MachineRepository repo;

	public MachineService() {

	}

	public void save(Machine m) {
		if (m != null)
			repo.save(m);
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
