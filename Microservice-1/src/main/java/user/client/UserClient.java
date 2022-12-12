package user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Microservice-2", url = "http://microservice2:8092")
public interface UserClient {

	   @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = "application/json", produces = "application/json;charset=UTF-8")
	    String sendUserForInsertToSecondService(@RequestBody String json);
}
