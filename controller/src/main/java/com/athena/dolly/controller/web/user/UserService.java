package com.athena.dolly.controller.web.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements InitializingBean {
	
	@Autowired
	private IUserRepository repo;

	public UserService() {
		//repo = new UserRepository();
	}

	public List<User> getList() {
		return repo.getList();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("\n\nrepo in UserService : " + repo);
	}
}
