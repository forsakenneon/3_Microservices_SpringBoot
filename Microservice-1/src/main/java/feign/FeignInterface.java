package feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Microservice-2", url = "localhost:8092")
public interface FeignInterface {
	
}
