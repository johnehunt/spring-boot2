package com.jjh.spring.graphql;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorForBookResolver implements GraphQLResolver<Book> {
	private com.jjh.graphql.AuthorDAO authorDao;

	@Autowired
	public AuthorForBookResolver(com.jjh.graphql.AuthorDAO authorDao) {
		this.authorDao = authorDao;
	}

	public Optional<com.jjh.graphql.Author> getAuthor(Book book) {
		System.out.println("BookQueryResolver.getAuthor(" + book + ")");
		return authorDao.getAuthor(book.getAuthorId());
	}
}
