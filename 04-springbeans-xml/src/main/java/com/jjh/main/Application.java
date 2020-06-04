package com.jjh.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.jjh.beans.CalculationService;
import com.jjh.beans.MessageService;

@ImportResource({"classpath*:applicationContext.xml"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println("Main - requesting CalculcationService");
		CalculationService calc = context.getBean("CalculationService", CalculationService.class);
		System.out.println("Main - "+ calc.calc("+", 10, 12));

		System.out.println("Main - requesting MessageService");
		MessageService messageService = context.getBean("MessageService", MessageService.class);
		System.out.println("Main - "+ messageService.getMessage());
		
		System.out.println("Main - requesting Servicio");
		MessageService servicio = context.getBean("Servicio", MessageService.class);
		System.out.println("Main - "+ servicio.getMessage());
	}

}
