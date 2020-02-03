package com.jjh.spring.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	private BookDao bookDao;

	public Mutation(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Book writeBook(String isbn, String title, String category, String author) {
		Book book = new Book(isbn, title, category, author);
		bookDao.saveBook(book);
		return book;
	}
}
