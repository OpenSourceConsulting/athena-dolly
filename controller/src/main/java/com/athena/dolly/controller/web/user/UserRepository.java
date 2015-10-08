package com.athena.dolly.controller.web.user;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Repository
public class UserRepository implements IUserRepository {

	@Override
	public boolean insert(UserDto user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDto> getList() {
		// TODO Auto-generated method stub
		List<UserDto> users = new ArrayList<UserDto>();
		// FileReader reader;

		// reader = new FileReader("src\\mainresources\\users.json");
		JsonParser parser = new JsonParser();
		JsonArray jsonArr = parser
				.parse("[{\"userId\":\"admin\",\"userName\":\"Administrator\",\"password\":\"admin\",\"email\":\"admin@osci.kr\"},{\"userId\":\"admin2\",\"userName\":\"Administrator2\",\"password\":\"admin2\",\"email\":\"admin2@osci.kr\"}]")
				.getAsJsonArray();
		for (int i = 0; i < jsonArr.size(); i++) {
			JsonObject obj = jsonArr.get(i).getAsJsonObject();
			users.add(new UserDto(obj.get("userId").getAsString(), obj.get(
					"password").getAsString()));
		}

		return users;
	}

}
