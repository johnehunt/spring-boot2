package com.jjh.spring.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
	private BookDao bookDao;

	public Query(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(int count) {
		return bookDao.getBooks(count);
	}
}
