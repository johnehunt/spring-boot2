package com.jjh.spring.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class AuthorQueryResolver implements GraphQLResolver<Author> {
	private BookDAO bookDao;

	public AuthorQueryResolver(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		System.out.println("AuthorResolver.getBooks(" + author + ")");
		return bookDao.getAuthorBooks(author.getId());
	}
}