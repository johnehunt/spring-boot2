package com.jjh.bookshop.client.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jh.bookshop.domain.Book;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
	
	
	@Value("${server.url}")
	private String serverBaseUrl;
	
	@Autowired
	private RestTemplate restTemnplate;


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	public void run(String... args) {
		System.out.println("serverBaseUrl: " + serverBaseUrl);
		System.out.println("-----------------");

		System.out.println("List the books");
		String url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		String result = restTemnplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		System.out.println("Get a book");
		url = serverBaseUrl + "/1";
		result = restTemnplate.getForObject(url, String.class);
		System.out.println("book: " + result);

		System.out.println("-----------------");

		System.out.println("Add a book");
		url = serverBaseUrl;
		Book book = new Book("2", "Bill Jones", "EE Java", 12.45);
		ResponseEntity<String> result1 = restTemnplate.postForEntity(url, book, String.class);
		System.out.println("Post Result: " + result1);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemnplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		// Update the Book
		System.out.println("Update the Book: " + book);
		book.setPrice(11.55);
		url = serverBaseUrl;
		restTemnplate.put(url, book);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemnplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		System.out.println("Delete the book: " + book);
		url = serverBaseUrl + "/" + book.getISBN();
		restTemnplate.delete(url);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemnplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

	}
}