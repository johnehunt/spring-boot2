package com.jjh.spring.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {
	private BookDAO bookDao;

	@Autowired
	public AuthorResolver(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<Book> getBooks(Author author) {
		System.out.println("AuthorResolver.getBooks(" + author + ")");
		return bookDao.getAuthorBooks(author.getId());
	}
}