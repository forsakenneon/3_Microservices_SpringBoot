package com.m1.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m1.db.service.DBService;
import com.m1.feign.FeignService;
import com.m1.user.utils.UserUtils;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private FeignService feign;

	@PostMapping("/add")
	public void postUser(@RequestBody String jsonUser) {
		String id = UserUtils.generateId();
		DBService.addFirstName(jsonUser, id);
		feign.PostMidName(jsonUser, id);
	}

	@PutMapping("/update")
	public void putUser(@RequestBody String jsonUser) throws Exception {
		String id = DBService.getIdFromJsonBody(jsonUser);
		DBService.updateFirstName(jsonUser, id);
		feign.PutMidName(jsonUser, id);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestBody String jsonID) throws Exception {
		String id = DBService.getIdFromJsonBody(jsonID);
		feign.DeleteMidName(id);
		DBService.deleteFirstName(id);
	}

}
