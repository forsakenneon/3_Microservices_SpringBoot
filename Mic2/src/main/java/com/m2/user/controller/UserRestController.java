package com.m2.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m2.user.User;
import com.m2.db.service.DBService;
import com.m2.utils.JsonUtil;
import com.m2.webclient.WebClientService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private WebClientService webClientService;

	/*@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser, @RequestParam String id) throws Exception {
		DBService.addMiddleName(jsonUser, id);
		User user = JsonUtil.fromJsontoUser(jsonUser);
		user.set_id(id);
		webClientService.create(user);
	}*/
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void postUserToMic3(@RequestBody String jsonUser, @RequestParam String id) throws Exception {
		DBService.addMiddleName(jsonUser, id);
		User user = JsonUtil.fromJsontoUser(jsonUser);
		user.set_id(id);
		webClientService.create(user);
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
