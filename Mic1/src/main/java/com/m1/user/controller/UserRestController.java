package com.m1.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.feign.FeignService;


@RestController
@RequestMapping ("/user")
public class UserRestController {
	
	@Autowired
	private FeignService feign;
	
	@PostMapping("/add")
	public void a(){
		feign.post();
	}

}
