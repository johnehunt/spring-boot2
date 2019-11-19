package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:mvcContext.xml" })
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("Main - Starting Setup");
		SpringApplication.run(Application.class, args);
		System.out.println("Main - Done Setup");
	}
}
