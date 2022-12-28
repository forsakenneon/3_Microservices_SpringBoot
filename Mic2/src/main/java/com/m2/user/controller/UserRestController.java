package com.m2.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/user")
public class UserRestController {

	@PostMapping("/add")
	public void a(){
		var a = 1;
		var b = a + 2;
	}
}
