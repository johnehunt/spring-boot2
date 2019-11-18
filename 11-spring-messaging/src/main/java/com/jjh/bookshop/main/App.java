package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jjh.bookshop.domain.Book;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Starting");
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		Sender sender = context.getBean(Sender.class);

		// Publish a book
		System.out.println("Sending an book message.");

		Book book = new Book("1", "Java Forever", "Jasmine Smith", 12.55);

		sender.send(book);

		System.out.println("Press Enter to Terminate");
		System.in.read();

	}
}
