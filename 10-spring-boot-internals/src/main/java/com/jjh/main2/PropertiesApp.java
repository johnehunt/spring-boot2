package com.jjh.main2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PropertiesApp {

	
	public static void main(String [] args) throws IOException {
		System.out.println("Starting");
		ConfigurableApplicationContext ctx = SpringApplication.run(PropertiesApp.class, args);
		MyInfo info = ctx.getBean(MyInfo.class);
		System.out.println(info.appName);
		System.out.println(info.getId());
		System.out.println(info.getConfigLocation());
		
		MyAppProperties props = ctx.getBean(MyAppProperties.class);
		System.out.println(props.getName());
		System.out.println(props.getDescription());
		
		System.out.println("Done");
	}

}
