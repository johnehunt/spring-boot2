package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// May need to turn off security auto-configuration to do it all ourselves
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
    	System.out.println("Starting the Hello World web application");
        SpringApplication.run(Main.class, args);
        System.out.println("Startup complete");
        System.out.println("See:");
        System.out.println("\t - http://localhost:8080/welcome/help");
        System.out.println("\t - http://localhost:8080/welcome/hello");
    }
}
