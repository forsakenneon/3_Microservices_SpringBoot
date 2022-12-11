package main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import db.service.DBService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.HTTPUtils;

@SpringBootApplication
@RestController
public class Microservice1Application {
	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
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
}