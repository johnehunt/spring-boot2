package com.jjh.spring.graphql;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	private BookDao bookDao;

	public Mutation(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Book writeBook(String title, String category, String author) {
		Book post = new Book();
		post.setIsbn(UUID.randomUUID().toString());
		post.setTitle(title);
		post.setCategory(category);
		post.setAuthorId(author);
		bookDao.saveBook(post);

		return post;
	}
}
