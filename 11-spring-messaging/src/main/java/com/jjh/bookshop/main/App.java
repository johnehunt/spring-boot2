package com.jjh.bookshop.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jjh.bookshop.domain.Book;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Starting");
		ApplicationContext context = SpringApplication.run(App.class, args);

		System.out.println("Press Enter to Continue");
		System.in.read();

		Sender sender = context.getBean(Sender.class);
		// Publish a book
		System.out.println("Sending a book message.");
		Book book = new Book("1",
				"Java Forever",
				"Jasmine Smith",
				12.55);
		sender.send(book);

		System.out.println("Press Enter to Terminate");
		System.in.read();

	}
}
