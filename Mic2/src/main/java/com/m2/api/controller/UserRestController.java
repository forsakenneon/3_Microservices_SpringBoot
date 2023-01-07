package com.m2.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m2.db.entity.User;
import com.m2.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
	
	private final UserService userService;
	
	@GetMapping(path="/get/{id}")
	public void getUser(@PathVariable String id) {
		userService.getUser(id);
	}
	
	@PostMapping("/add/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void postUserToMic3(@RequestBody User user, @PathVariable String id) throws Exception {
		userService.postUser(user, id);
	}

	@PutMapping("/update/{id}")
	public void putUser(@RequestBody User user, @PathVariable String id) throws Exception {
		userService.putUser(user, id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
