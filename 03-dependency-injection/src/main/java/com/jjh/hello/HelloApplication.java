package com.jjh.hello;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jjh.beans.MessageService;
import com.jjh.beans.WelcomeService;

@ComponentScan(basePackages = "com.jjh.beans")
@SpringBootApplication
public class HelloApplication {
	

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
		
		System.out.println("Main - requesting MessageService");
		WelcomeService service = (WelcomeService)ctx.getBean(WelcomeService.class);
		
		String result = service.getWelcomeInfo("John", new Date());
		System.out.println("Result: " + result);
		
	}

}