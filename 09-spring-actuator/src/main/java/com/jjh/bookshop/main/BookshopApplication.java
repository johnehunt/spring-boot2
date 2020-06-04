package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// To turn off security for actuator need to use
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.bookshop.controller,com.jjh.bookshop.service")
@EntityScan("com.jjh.bookshop.domain")
@EnableJpaRepositories("com.jjh.bookshop.repository")
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
