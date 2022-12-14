package feign;

import java.io.IOException;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@FeignClient(name = "Microservice-1", url = "localhost:8091")
public interface FeignService {
	@GetMapping("/GetUser")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@PostMapping("/PostUser")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@PutMapping("/UpdateUser")
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@DeleteMapping("/DeleteUser")
	public void doDelete(HttpServletRequest request, HttpServletResponse response);
}
