package com.jjh.bookshop.client.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:client-rest.properties")
public class AppConfig  { 
	
	public AppConfig() {
		System.out.println("Starting AppConfig");
	}
	
	@Autowired
	Environment env;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertiesResolver() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public RestTemplate restTemnplate() {
		return new RestTemplate();
	}

	
}
