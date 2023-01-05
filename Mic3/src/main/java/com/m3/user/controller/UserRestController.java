package com.m3.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m3.db.service.DBService;
import com.m3.user.User;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@PostMapping("/add")
	public void postUser(@RequestBody User user) throws Exception {
		DBService.addLastName(user);
	}
}
