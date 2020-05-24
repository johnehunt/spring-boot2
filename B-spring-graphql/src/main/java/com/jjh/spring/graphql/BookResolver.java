package com.jjh.spring.graphql;

import java.util.Optional;

import graphql.kickstart.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
	private AuthorDAO authorDao;

	public BookResolver(AuthorDAO authorDao) {
		this.authorDao = authorDao;
	}

	public Optional<Author> getAuthor(Book book) {
		System.out.println("BookQueryResolver.getAuthor(" + book + ")");
		return authorDao.getAuthor(book.getAuthorId());
	}
}
