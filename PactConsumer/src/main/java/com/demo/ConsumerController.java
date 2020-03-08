package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/cons/{name}/{age}")
	public String hello(@PathVariable String name, @PathVariable int age) {
		String baseUrl = "http://localhost:7555/pro/seelan/29";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		WorkModel responseEntity = restTemplate.getForObject(baseUrl, WorkModel.class);
		return responseEntity.getWelcome();
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
