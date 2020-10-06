package com.jjh.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jjh.mvc")
public class HelloWorldWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.jjh.app.HelloWorldWebApplication.class, args);
	}

}
