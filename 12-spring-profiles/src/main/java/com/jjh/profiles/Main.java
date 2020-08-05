package com.jjh.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jjh.config")
public class Main {

	public static void main(String[] args) {
		System.out.println("Starting Up");

		SpringApplication app = new SpringApplication(Main.class);
		app.setAdditionalProfiles("dev");

		ConfigurableApplicationContext ctx = app.run(args);

		String name = ctx.getBean("name", String.class);
		System.out.println(name);

		// Only works with dev profile - as not set for prod or test
		String info = ctx.getBean("info", String.class);
		System.out.println(info);
		System.out.println("Exiting Main Application!");
	}
}
