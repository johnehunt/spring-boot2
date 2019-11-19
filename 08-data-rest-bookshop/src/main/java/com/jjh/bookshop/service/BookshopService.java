package com.jjh.bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookNotFoundException;
import com.jjh.bookshop.repository.BookRepository;

@Component
public class BookshopService {

	@Autowired
	BookRepository repository;

	public BookshopService() {
		System.out.println("BookshopService.<init>()");
	}

	public List<Book> getAllBooks() {
		System.out.println("BookshopService.getAllBooks()");
		return (List<Book>) repository.findAll();
	}

	public void addBook(Book book) {
		System.out.println("BookshopService.addBook(" + book + ")");
		this.repository.save(book);
	}

	public void updateBook(Book newVersionOfBook) {
		System.out.println("BookshopService.updateBook(" + newVersionOfBook + ")");
		this.repository.save(newVersionOfBook);
	}

	public void deleteBook(String isbn) {
		System.out.println("BookshopService.deleteBook(" + isbn + ")");
		repository.deleteById(isbn);
	}

	public Book getBook(String isbn) {
		System.out.println("BookshopService.getBook(" + isbn + ")");
		Optional<Book> optionalBook = repository.findById(isbn);
		return optionalBook.orElseThrow(() -> new BookNotFoundException("Couldn't find a Dog with id: " + isbn));
	}

}
