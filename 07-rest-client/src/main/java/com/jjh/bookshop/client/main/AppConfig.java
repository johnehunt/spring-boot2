package com.jjh.bookshop.client.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:client-rest.properties")
public class AppConfig  { 
	
	public AppConfig() {
		System.out.println("Instantiating AppConfig");
	}
	
	@Bean
	public RestTemplate restTemnplate() {
		return new RestTemplate();
	}

	
}
