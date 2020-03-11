package com.jjh.mircoservcies.shop;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jjh.microservices.books.Book;

@RestController
public class ShopController {
	
	private BookServiceDelegate userService;
	
	public ShopController(BookServiceDelegate userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<Book> getBooks() {
		System.out.println("ShopService.getBooks() - ");
		return this.userService.getBooks();
	}


}
