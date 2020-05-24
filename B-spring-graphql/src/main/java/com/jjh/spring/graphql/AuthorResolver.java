package com.jjh.spring.graphql;

import java.util.List;

import graphql.kickstart.tools.GraphQLResolver;

public class AuthorResolver implements GraphQLResolver<Author> {
	private BookDAO bookDao;

	public AuthorResolver(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		System.out.println("AuthorResolver.getBooks(" + author + ")");
		return bookDao.getAuthorBooks(author.getId());
	}
}