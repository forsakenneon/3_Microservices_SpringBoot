package com.m1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.m1.db.entity.User;
import com.m1.db.repository.UserRepository;
import com.m1.feign.FeignService;
import com.m1.user.utils.UserUtils;
import com.m1.utils.JsonUtil;

@Service
@Component
public class UserService {
	
	@Autowired
	private FeignService feign;
	
	public String getUser(String id) {
		String user= null;
		try {
			String firstname = UserRepository.getFirstName(id);
			String middlename = feign.GetMidName(id);
			user = firstname + " " + middlename;
			System.out.println("Firstname is - " + firstname + " Middlename is - " + middlename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void postUser(String jsonUser) {
		String id = UserUtils.generateId();
		User user;
		try {
			user = JsonUtil.fromJsontoUser(jsonUser);
			UserRepository.addFirstName(user, id);
			feign.PostMidName(user, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void putUser(String jsonUser, String id) {
		User user;
		try {
			user = JsonUtil.fromJsontoUser(jsonUser);
			UserRepository.updateFirstName(user, id);
			feign.PutMidName(user, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(String id){
		UserRepository.deleteFirstName(id);
		feign.DeleteMidName(id);
	}
}
