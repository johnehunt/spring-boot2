package com.jjh.spring.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public class Query implements GraphQLQueryResolver {
	private BookDao bookDao;

	public Query(BookDao postDao) {
		this.bookDao = postDao;
	}

	public List<Book> getRecentBooks(int count, int offset) {
		return bookDao.getRecentBooks(count, offset);
	}
}
