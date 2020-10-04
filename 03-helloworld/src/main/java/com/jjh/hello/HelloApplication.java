package com.jjh.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		System.out.println("Starting Up");
		SpringApplication.run(HelloApplication.class, args);
		System.out.println("Hello World");
	}

}
