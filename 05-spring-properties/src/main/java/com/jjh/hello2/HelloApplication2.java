package com.jjh.hello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class HelloApplication2 {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HelloApplication2.class, args);

		System.out.println("Main - obtaining DriverManagerDataSource");
		DriverManagerDataSource datasource = context.getBean("dataSource", DriverManagerDataSource.class);
		System.out.println(datasource);
		System.out.println(datasource.getUrl());
		System.out.println(datasource.getUsername());
		System.out.println(datasource.getPassword());
	}

}
