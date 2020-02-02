package com.jjh.spring.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringPostApp extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		System.out.println("Starting App setup");
		SpringApplication.run(SpringPostApp.class, args);
		System.out.println("Setup finished");
	}

}