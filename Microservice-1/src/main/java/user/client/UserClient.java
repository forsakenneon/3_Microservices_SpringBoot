package user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Microservice-2", url = "http://microservice2:8092")
public interface UserClient {
	@RequestMapping(method = RequestMethod.GET, value = "/user?id={id}", consumes = "application/json", produces = "application/json;charset=UTF-8")
	String readUserFromSecondService(@PathVariable("id") long id);

	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = "application/json", produces = "application/json;charset=UTF-8")
	String sendUserForInsertToSecondService(@RequestBody String json);

	@RequestMapping(method = RequestMethod.PUT, value = "/users?id={id}", consumes = "application/json", produces = "application/json;charset=UTF-8")
	String sendUserForUpdateToSecondService(@PathVariable("id") long id, @RequestBody String json);

	@RequestMapping(method = RequestMethod.DELETE, value = "/users?id={id}", consumes = "application/json", produces = "application/json;charset=UTF-8")
	String sendIdForDeleteToSecondService(@PathVariable("id") long id);
}