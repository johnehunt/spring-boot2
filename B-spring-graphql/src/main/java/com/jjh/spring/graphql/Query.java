package com.jjh.spring.graphql;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
	private BookDAO bookDao;

	public Query(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(int count) {
		System.out.println("Query.getBooks(" + count + ")");
		return bookDao.getBooks(count);
	}
}
