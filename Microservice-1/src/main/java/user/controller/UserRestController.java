package user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
	// TODO: 1. Get LIST USERS (middlenames, lastnames) From Second Sevice
	// TODO: 2. Get Firstnames of USERS from Database MONGODB and add them to LIST
	// USERS (middlenames, lastnames)
	// TODO: 3. Send HTTP response LIST USERS
	@GetMapping("/all")
	public List<User> getAll() {
		
		return null;
	}
}
