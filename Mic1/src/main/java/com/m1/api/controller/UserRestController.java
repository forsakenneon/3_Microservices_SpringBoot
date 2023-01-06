package com.m1.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
	
	private final UserService userService;
	
	@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser) throws Exception {
		userService.postUser(jsonUser);
	}

	@PutMapping(path="/update/{id}")
	public void putUser(@RequestBody String jsonUser, @PathVariable String id) throws Exception {
		userService.putUser(jsonUser, id);
	}

	@DeleteMapping(path="/delete/{id}")
	public void deleteUser(@PathVariable String id) throws Exception {
		userService.deleteUser(id);
	}

}