package com.m1.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.db.service.DBService;
import com.m1.feign.FeignService;
import com.m1.user.utils.UserUtils;


@RestController
@RequestMapping ("/user")
public class UserRestController {
	
	@Autowired
	private FeignService feign;
	
	@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser){
		String id = UserUtils.generateId();
		DBService.addOne(jsonUser, id);
		feign.sendUserToMicroservice2(jsonUser, id);
	}

}
