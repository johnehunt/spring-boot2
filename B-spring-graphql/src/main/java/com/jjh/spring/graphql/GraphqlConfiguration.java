package com.jjh.spring.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
	@Bean
	public BookDAO bookDao() {
		return new BookDAO();
	}

	@Bean
	public AuthorDAO authorDao() {
		return new AuthorDAO();
	}

	@Bean
	public BookQueryResolver bookQueryResolver(AuthorDAO authorDao) {
		return new BookQueryResolver(authorDao);
	}

	@Bean
	public AuthorQueryResolver authorQueryResolver(BookDAO postDao) {
		return new AuthorQueryResolver(postDao);
	}

	@Bean
	public Query query(BookDAO bookDao) {
		return new Query(bookDao);
	}

	@Bean
	public Mutation mutation(BookDAO bookDao) {
		return new Mutation(bookDao);
	}
}
