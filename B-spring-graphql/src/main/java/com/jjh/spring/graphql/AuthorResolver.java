package com.jjh.spring.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class AuthorResolver implements GraphQLResolver<Author> {
	private BookDao postDao;

	public AuthorResolver(BookDao bookDao) {
		this.postDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		return postDao.getAuthorBooks(author.getId());
	}
}