package com.jjh.bookshop.client.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jjh.bookshop.domain.Book;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	@Value("${server.url}")
	private String serverBaseUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	/**
	 * CommandLine runner interface used to allow injection of
	 * server.url and rest template bean. These happen after
	 * the Spring Context is initialised i.e. which is only
	 * guaranteed to inject the values once the main method runs.
	 * The run method is then called by Spring allowing the code
	 * to access both injected dependencies.
	 * @param args
	 */
	public void run(String... args) {
		System.out.println("serverBaseUrl: " + serverBaseUrl);
		System.out.println("-----------------");

		System.out.println("List the books");
		String url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		String result = restTemplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		System.out.println("Get a book");
		url = serverBaseUrl + "/1";
		result = restTemplate.getForObject(url, String.class);
		System.out.println("book: " + result);

		System.out.println("-----------------");

		System.out.println("Add a book");
		url = serverBaseUrl;
		Book book = new Book("2", "Bill Jones", "EE Java", 12.45);
		ResponseEntity<String> result1 = restTemplate.postForEntity(url, book, String.class);
		System.out.println("Post Result: " + result1);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		// Update the Book
		System.out.println("Update the Book: " + book);
		book.setPrice(11.55);
		url = serverBaseUrl;
		restTemplate.put(url, book);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

		System.out.println("Delete the book: " + book);
		url = serverBaseUrl + "/" + book.getISBN();
		restTemplate.delete(url);

		System.out.println("-----------------");

		System.out.println("List the books");
		url = serverBaseUrl + "/list";
		System.out.println("url: " + url);
		result = restTemplate.getForObject(url, String.class);
		System.out.println("List: " + result);

		System.out.println("-----------------");

	}
}
