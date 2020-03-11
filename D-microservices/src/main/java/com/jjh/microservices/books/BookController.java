package com.jjh.microservices.books;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	private List<Book> books = Stream
			.of(new Book("1", "Java Today", "John", 15.55), 
				new Book("2", "Spring 2.x", "Paul", 12.99))
			.collect(Collectors.toList());

	@GetMapping
	public List<Book> getBooks() {
		System.out.println("BookService.getBooks() - " + books);
		return this.books;
	}

}
