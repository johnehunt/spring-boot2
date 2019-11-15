package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.bookshop.controller,com.jjh.bookshop.service")
public class BookshopApplication {

	public static void main(String[] args) {
		System.out.println("Starting Bookshop setup");
		SpringApplication.run(BookshopApplication.class, args);
		System.out.println("Setup finished");
	}

}
