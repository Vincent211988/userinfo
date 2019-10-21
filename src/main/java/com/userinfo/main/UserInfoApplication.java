package com.userinfo.main;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.userinfo.controller.EncryptResponse;


@ComponentScan("com.userinfo.controller")
@SpringBootApplication
public class UserInfoApplication{
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserInfoApplication.class, args);
	}
	
	/*@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			EncryptResponse res = restTemplate.getForObject("http://127.0.0.1:8200/v1/transit/encrypt/Vincent", EncryptResponse.class);
			System.out.println(res.getRequestId());
		};
	}*/
	
}
