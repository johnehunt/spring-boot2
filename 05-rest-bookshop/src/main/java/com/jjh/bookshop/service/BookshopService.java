package com.jjh.bookshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jh.bookshop.domain.Book;
import com.jh.bookshop.domain.BookNotFoundException;

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

	public Book addBook(Book book) {
		System.out.println("BookshopService.addBook(" + book + ")");
		if (!this.contents.contains(book)) {
			this.contents.add(book);
		}
		return book;
	}

	public Book updateBook(Book newVersionOfBook) {
		System.out.println("BookshopService.updateBook(" + newVersionOfBook + ")");
		Book originalBook = this.getBook(newVersionOfBook.getISBN());
		if (originalBook == null)
			throw new BookNotFoundException("Book with isbn: " + newVersionOfBook.getISBN() + " not found");
		originalBook.setAuthor(newVersionOfBook.getAuthor());
		originalBook.setTitle(newVersionOfBook.getTitle());
		originalBook.setPrice(newVersionOfBook.getPrice());
		return newVersionOfBook;
	}

	public void deleteBook(String id) {
		Book book = this.getBook(id);
		System.out.println("BookshopService.deleteBook(" + book + ")");
		if (book != null)
			this.contents.remove(book);
		else
			throw new BookNotFoundException("Book with isbn: " + id + " not found");
	}

	public Book getBook(String isbn) {
		System.out.println("BookshopService.getBook(" + isbn + ")");
		System.out.println(this.contents);
		List<Book> books = this.contents.stream().filter(b -> b.getISBN().equalsIgnoreCase(isbn))
				.collect(Collectors.toList());
		System.out.println(books);
		if (books.size() > 0)
			return books.get(0);
		else
			return null;
	}
}
