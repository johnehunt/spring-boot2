package com.jjh.spring.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDao {
	private List<Book> books = new ArrayList<>();

	public BookDao() {
		books.add(new Book("121", "Java", "Technical", "1"));
		books.add(new Book("345", "Death in the Spring", "Detective", "2"));
		books.add(new Book("987", "Henry VI", "Historical", "3"));
	}

	public List<Book> getBooks(int count) {
		return books.stream().limit(count).collect(Collectors.toList());
	}

	public List<Book> getAuthorBooks(String author) {
		return books.stream().filter(b -> author.equals(b.getAuthorId())).collect(Collectors.toList());
	}

	public void saveBook(Book book) {
		books.add(book);
	}
}
