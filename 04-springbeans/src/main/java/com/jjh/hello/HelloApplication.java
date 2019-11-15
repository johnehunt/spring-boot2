package com.jjh.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jjh.beans.CalculationService;
import com.jjh.beans.DataService;
import com.jjh.beans.PrintService;
import com.jjh.logging.LoggingService;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.hello,com.jjh.beans")
public class HelloApplication {
	

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
		
		System.out.println("Main - requesting MessageService");
		//MessageService service = (MessageService)ctx.getBean("MessageService");
		MessageService service = ctx.getBean(MessageService.class);
		System.out.println(service.getMessage());
		
		System.out.println("Main - requesting MessageService (again)");
		MessageService s2 = ctx.getBean(MessageService.class);
		if (service == s2) {
			System.out.println("Main -> They are the same service instance");
		}
		System.out.println("Main - requesting CalculationService");
		CalculationService calc = ctx.getBean(CalculationService.class);
		System.out.println("Main - " + calc.calc("+", 10, 12));
	
		System.out.println("Main - requesting CalculationService (again)");
		CalculationService calc2 = ctx.getBean(CalculationService.class);
		System.out.println("Main - " + calc2.calc("+", 8, 6));
		
		PrintService printer = ctx.getBean(PrintService.class);
		printer.print("Hello");
		
		LoggingService logging = ctx.getBean(LoggingService.class);
		logging.log("logged message");
		
		DataService data = ctx.getBean("MyDataService", DataService.class);
		System.out.println(data.getData());
		
	}

}
