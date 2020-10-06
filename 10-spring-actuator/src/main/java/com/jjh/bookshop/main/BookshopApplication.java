package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// To turn off security for actuator need to use
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})

@SpringBootApplication
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
		System.out.println("Url to try with Actuator:");
		System.out.println("\t - http://localhost:8080/actuator/health");
		System.out.println("You will need to login for:");
		System.out.println("\t - http://localhost:8080/actuator");

	}

}

/**
 * Can shut down using curl -X POST localhost:port/actuator/shutdown
 */
