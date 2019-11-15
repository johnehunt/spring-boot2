package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("Starting the Hello World web application");
		SpringApplication.run(Application.class, args);
		System.out.println("Startup complete");
	}
}
