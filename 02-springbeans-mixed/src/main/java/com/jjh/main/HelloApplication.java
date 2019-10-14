package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.jjh.beans.CalculationService;
import com.jjh.beans.MessageService;

@ImportResource({"classpath*:beans.xml"})
@ComponentScan(basePackages = "com.jjh.beans")
@SpringBootApplication
public class HelloApplication {
	

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
		
		System.out.println("Main - requesting CalculcationService");
		CalculationService calc = ctx.getBean("CalculationService", CalculationService.class);
		System.out.println("Main - "+ calc.calc("+", 10, 12));

		System.out.println("Main - requesting MessageService");
		MessageService messageService = ctx.getBean("MessageService", MessageService.class);
		System.out.println("Main - "+ messageService.getMessage("John"));
		
		System.out.println("Done");
		
	}

}
