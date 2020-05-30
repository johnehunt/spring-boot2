package com.jjh.spring.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	
	private BookDAO bookDao;

	@Autowired
	public Query(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(int count) {
		System.out.println("Query.getBooks(" + count + ")");
		return bookDao.getBooks(count);
	}
}
