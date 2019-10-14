package com.jjh.hello3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ImportResource({"classpath*:beans.xml"})
public class HelloApplication3 {
	

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext context = SpringApplication.run(HelloApplication3.class, args);
		
		DriverManagerDataSource datasource = context.getBean("dataSource", DriverManagerDataSource.class);
		System.out.println(datasource);
		System.out.println(datasource.getUrl());
		System.out.println(datasource.getUsername());
		System.out.println(datasource.getPassword());
	}

}
