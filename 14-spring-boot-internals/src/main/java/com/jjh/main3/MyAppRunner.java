package com.jjh.main3;

import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppRunner implements CommandLineRunner, ApplicationRunner {
	
	public static void main(String [] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
		SpringApplication.run(MyAppRunner.class, args);
	}

	public void run(ApplicationArguments args) {
		System.out.println("Application Runner Implementation");
		args.getNonOptionArgs().forEach(option -> System.out.println(option));
	}

	public void run(String... args) {
		System.out.println("CommandLine Runner Implementation");
		for (String option : args) 
			System.out.println(option);
	}

}
