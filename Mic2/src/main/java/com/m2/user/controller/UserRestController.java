package com.m2.user.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2.db.service.DBService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser,@RequestParam String id) throws Exception {
		System.out.println("Waiting a 2 sec");
		System.out.println("User id is:" + id);
		TimeUnit.SECONDS.sleep(2);
		DBService.addOne(jsonUser, id);
	}
}
