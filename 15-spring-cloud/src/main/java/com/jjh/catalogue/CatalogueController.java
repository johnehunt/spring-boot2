package com.jjh.catalogue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class CatalogueController {
	
	private List<Book> books = new ArrayList<Book>();

	public CatalogueController() {
		System.out.println("CatalogueController.<cons>()");
		books.add(new Book("123", "John Smith", "Java for All", 19.55));
		books.add(new Book("234", "Denise Byrne", "Spring in Time", 15.45));
		books.add(new Book("234", "Phoebe Adams", "Microservices", 12.33));
	}

	@GetMapping
	public List<Book> getBooks() {
		System.out.println("CatalogueController.getBooks() - " + books);
		return this.books;
	}
}
