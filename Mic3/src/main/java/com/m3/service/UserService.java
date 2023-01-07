package com.m3.service;

import org.springframework.stereotype.Component;

import com.m3.db.entity.User;
import com.m3.db.repository.UserRepository;

@Component
public class UserService {
	public void postUser(User user, String id) throws Exception {
		UserRepository.addLastName(user, id);
	}

	public void putUser(User user, String id) throws Exception {
		UserRepository.updateLastName(user, id);
	}

	public void deleteUser(String id) {
		UserRepository.deleteLastName(id);
	}
}
