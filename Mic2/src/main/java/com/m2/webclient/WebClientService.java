package com.m2.webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.m2.user.User;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {

	WebClient webClient = WebClient.builder().baseUrl("http://localhost:8093/user")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();
	
	/*
	 * public Mono<ClientResponse> create(User user) { return this.webClient.post()
	 * .uri("/add") .header(HttpHeaders.CONTENT_TYPE,
	 * MediaType.APPLICATION_JSON_VALUE) .body(Mono.just(user), User.class)
	 * .exchange(); }
	 */
	
	public ClientResponse create(User user) {
		return webClient.post().uri("/add").body(Mono.just(user), User.class).retrieve()
				.bodyToMono(ClientResponse.class).block();
	}
}
