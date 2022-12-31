package com.m1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "m1", url = "http://localhost:8092")
public interface FeignService {

	@PostMapping(value = "/user/add")
	String PostMidName(@RequestBody String jsonUser, @RequestParam String id);

	@PutMapping(value = "/user/update")
	String PutMidName(@RequestBody String jsonUser, @RequestParam String id);

	@DeleteMapping(value = "/user/delete")
	String DeleteMidName(@RequestParam String id);
}