package com.jjh.integration;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
	public static void main(String... args) {
		final AbstractApplicationContext context = new AnnotationConfigApplicationContext(SimpleIntegrationConfig.class);
		context.registerShutdownHook();

		final Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter q and press <enter> to exit the program: ");
		while (true) {
			String input = scanner.nextLine();
			if ("q".equals(input.trim())) {
				break;
			}
		}

		scanner.close();
		context.close();
		System.exit(0);
	}
}
