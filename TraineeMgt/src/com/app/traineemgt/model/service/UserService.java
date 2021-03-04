package com.app.traineemgt.model.service;

import com.app.traineemgt.model.exceptions.UserNotFoundException;

public class UserService {
	public static User validateUser(String username, String password) {
		if(username.contentEquals(password)) {
			return new User(username, password);
		}else {
			throw new UserNotFoundException();
		}
	}

}
