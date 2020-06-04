package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.mvc")
public class Application {
    public static void main(String[] args) {
    	System.out.println("Starting the web application");
        SpringApplication.run(Application.class, args);
        System.out.println("Startup complete");
        System.out.println("See - http://localhost:8080/welcome/hello");
    }
}
