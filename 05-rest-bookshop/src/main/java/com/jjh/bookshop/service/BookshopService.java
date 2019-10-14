package com.jjh.bookshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookNotFoundException;

@Component
public class BookshopService {

	private List<Book> contents = new ArrayList<Book>();

	public BookshopService() {
		System.out.println("BookshopService.<init>()");
		contents.add(new Book("1", "John Smith", "Java World Topics", 15.55));
	}

	public List<Book> getAllBooks() {
		System.out.println("BookshopService.getAllBooks()");
		return this.contents;
	}

	public void addBook(Book book) {
		System.out.println("BookshopService.addBook(" + book + ")");
		if (!this.contents.contains(book)) {
			this.contents.add(book);
		}
	}

	public void updateBook(Book newVersionOfBook) {
		System.out.println("BookshopService.updateBook(" + newVersionOfBook + ")");
		Book originalBook = this.getBook(newVersionOfBook.getISBN());
		if (originalBook == null)
			throw new BookNotFoundException("Book with isbn: " + newVersionOfBook.getISBN() + " not found");
		originalBook.setAuthor(newVersionOfBook.getAuthor());
		originalBook.setTitle(newVersionOfBook.getTitle());
		originalBook.setPrice(newVersionOfBook.getPrice());
	}

	public void deleteBook(String isbn) {
		System.out.println("BookshopService.deleteBook(" + isbn + ")");
		Book book = this.getBook(isbn);
		if (book != null)
			this.contents.remove(book);
		else
			throw new BookNotFoundException("Book with isbn: " + isbn + " not found");
	}

	public Book getBook(String isbn) {
		System.out.println("BookshopService.getBook(" + isbn + ")");;
		List<Book> books = this.contents.stream().filter(b -> b.getISBN().equalsIgnoreCase(isbn))
				.collect(Collectors.toList());
		if (books.size() > 0)
			return books.get(0);
		else
			return null;
	}
}
