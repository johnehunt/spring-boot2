package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.beans")
public class App {
	public static void main(String[] args) {
		System.out.println("Starting Up");
		SpringApplication.run(App.class, args);
		System.out.println("Done");
	}
}
