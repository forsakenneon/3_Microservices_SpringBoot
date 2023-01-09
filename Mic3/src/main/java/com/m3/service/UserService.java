package com.m3.service;

import org.springframework.stereotype.Component;

import com.m3.db.entity.User;
import com.m3.db.repository.UserRepository;

@Component
public class UserService {
	
	public String getUser(String id) {
		String lastname = null;
		try {
			lastname = UserRepository.getLastName(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastname;
	}
	
	public void postUser(User user, String id) {
		try {
			UserRepository.addLastName(user, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void putUser(User user, String id) {
		try {
			UserRepository.updateLastName(user, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUser(String id) {
		UserRepository.deleteLastName(id);
	}
}
