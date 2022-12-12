package main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import db.service.DBService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.HTTPUtils;

@SpringBootApplication
@RestController
@EnableFeignClients
public class Microservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice3Application.class, args);
	}

	@GetMapping("/GetUser")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			response.getWriter().println("<h1>" + DBService.getAll() + "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/PostUser")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String jsonUser = HTTPUtils.getBody(request);
			DBService.addOne(jsonUser);
			response.setContentType("text/html");
			response.getWriter().println("<h1>" + "Added Student:" + jsonUser + "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("/UpdateUser")
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String jsonUser = HTTPUtils.getBody(request);
			DBService.updateOne(jsonUser);
			response.setContentType("text/html");
			response.getWriter().println("<h1>" + "Updated User:" + jsonUser + "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/DeleteUser")
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String jsonUser = HTTPUtils.getBody(request);
			DBService.deleteOne(jsonUser);
			response.setContentType("text/html");
			response.getWriter().println("<h1>" + "Deleted student with id:" + jsonUser + "</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
