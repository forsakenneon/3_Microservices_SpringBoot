package com.m1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "m1", url = "http://localhost:8092")
public interface FeignService {
	
	@PostMapping("/user/add")
    String post();
}
