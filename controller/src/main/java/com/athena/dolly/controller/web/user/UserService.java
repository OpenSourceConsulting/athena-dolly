package com.athena.dolly.controller.web.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private IUserRepository repo;

	public UserService() {
		repo = new UserRepository();
	}

	public List<UserDto> getList() {
		return repo.getList();
	}
}
