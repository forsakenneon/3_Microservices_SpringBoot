package com.m2.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2.db.service.DBService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser, @RequestParam String id) throws Exception {
		DBService.addMiddleName(jsonUser, id);
	}

	@PutMapping("/update")
	public void putUser(@RequestBody String jsonUser, @RequestParam String id) throws Exception {
		DBService.addMiddleName(jsonUser, id);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam String id) {
		DBService.deleteMiddleName(id);
	}
}
