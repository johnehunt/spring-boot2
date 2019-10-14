package com.jjh.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookNotFoundException;
import com.jjh.bookshop.service.BookshopService;

@RestController
@RequestMapping("bookshop")
public class BookshopController {
	
	@Autowired
    private BookshopService bookshop;
	
	@GetMapping("{isbn}")
	public Book getBook(@PathVariable String isbn) {
		System.out.println("BookshopController.getBook(" + isbn + ")");
		return this.bookshop.getBook(isbn);
	}
	
	@GetMapping("list")
	public List<Book> getAllBooks() {
		System.out.println("BookshopController.getAllBooks()");
		return bookshop.getAllBooks();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Book addBook(@RequestBody Book book) {
		System.out.println("BookshopController.addBook(" + book + ")");
		return this.bookshop.addBook(book);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@RequestBody Book book) {
		System.out.println("BookshopController.updateBook(" + book + ")");
		return this.bookshop.updateBook(book);
	}
	
	@DeleteMapping("{isbn}")
	// @RequestMapping(value = "{isbn}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteBook(@PathVariable String isbn) {
		System.out.println("BookshopController.deleteBook(" + isbn + ")");
		bookshop.deleteBook(isbn);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
	public void updateFailure() { }
	

}
