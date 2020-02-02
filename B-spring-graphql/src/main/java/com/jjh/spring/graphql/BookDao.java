package com.jjh.spring.graphql;

import java.util.List;
import java.util.stream.Collectors;

public class BookDao {
	private List<Book> books;

	public BookDao(List<Book> books) {
		this.books = books;
	}

	public List<Book> getRecentBooks(int count, int offset) {
		return books.stream().skip(offset).limit(count).collect(Collectors.toList());
	}

	public List<Book> getAuthorBooks(String author) {
		return books.stream().filter(post -> author.equals(post.getAuthorId())).collect(Collectors.toList());
	}

	public void saveBook(Book book) {
		books.add(0, book);
	}
}
