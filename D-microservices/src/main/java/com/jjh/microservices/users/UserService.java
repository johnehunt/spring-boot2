package com.jjh.microservices.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * A User Microservice
 *
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link UserServiceConfiguration}. This is a deliberate separation of
 * concerns.
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import(UserServiceConfiguration.class)
public class UserService {


	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args Program arguments - ignored.
	 */
	public static void main(String[] args) {
		System.out.println("Starting UserService");
		
		// Tell server to look for user-server.properties or
		// user-server.yml
		System.setProperty("spring.config.name", "user-server");

		SpringApplication.run(UserService.class, args);
		System.out.println("UserService start up completed");
	}

}
