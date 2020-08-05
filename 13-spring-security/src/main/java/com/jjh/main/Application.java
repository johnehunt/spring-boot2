package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// May need to turn off security auto-configuration to do it all ourselves
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
    	System.out.println("Starting the Hello World web application");
        SpringApplication.run(Application.class, args);
        System.out.println("Startup complete");
    }
}
