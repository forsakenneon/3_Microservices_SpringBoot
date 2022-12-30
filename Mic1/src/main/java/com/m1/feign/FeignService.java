package com.m1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "m1", url = "http://localhost:8092")
public interface FeignService {

	@PostMapping(value = "/user/add")
	String sendUserToMicroservice2(@RequestBody String jsonUser,@RequestParam String id);
}
