package com.jjh.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.jjh.beans.HelloWorld;

@ImportResource({"classpath*:bean-context.xml"})
@SpringBootApplication
public class HelloApplication {
	

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		
		System.out.println("main - Requesting HelloWorld bean");
		HelloWorld bean = context.getBean(HelloWorld.class);
		System.out.println(bean.getMessage("John"));
	}

}
