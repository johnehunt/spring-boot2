package com.jjh.microservices.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A Book Microservice
 *
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * 
 * Annotations do the work
 * @EnableAutoConfiguration - defines this as a Spring Boot application.
 * @EnableDiscoveryClient - this enables service registration and discovery. 
 * In this case, this process registers itself with the discovery-server 
 * service using its application name
 */
@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@ComponentScan
public class BookService {


	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args Program arguments - ignored.
	 */
	public static void main(String[] args) {
		System.out.println("Starting BookService");
		
		// Tell server to look for book-server.properties or
		// book-server.yaml
		System.setProperty("spring.config.name", "book-service");

		SpringApplication.run(BookService.class, args);
		System.out.println("BookService start up completed");
	}

}
