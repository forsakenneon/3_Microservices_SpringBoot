package com.m2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.m2.db.entity.User;
import com.m2.db.repository.UserRepository;
import com.m2.webclient.WebClientService;

@Service
@Component
public class UserService {
	
	@Autowired
	private WebClientService webClientService;
	
	public String getUser(String id) {
		String middlename = null;
		String lastname = null;
		try {
			middlename = UserRepository.getMiddleName(id); 
			lastname = webClientService.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return middlename + " Lastname is - " + lastname;
	}
	
	public void postUser(User user, String id) throws Exception {
		UserRepository.addMiddleName(user, id);
		webClientService.post(user, id);
	}

	public void putUser(User user, String id) throws Exception {
		UserRepository.updateMiddleName(user, id);
		webClientService.put(user, id);
	}

	public void deleteUser(String id) {
		UserRepository.deleteMiddleName(id);
		webClientService.delete(id);
	}
}
