package com.jjh.spring.graphql;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorQueryResolver implements GraphQLResolver<com.jjh.graphql.Author> {
	private Bookshop bookshop;

	@Autowired
	public AuthorQueryResolver(Bookshop bookshop) {
		this.bookshop = bookshop;
	}

	public List<Book> getBooks(com.jjh.graphql.Author author) {
		System.out.println("AuthorResolver.getBooks(" + author + ")");
		return bookshop.getAuthorBooks(author.getId());
	}
}