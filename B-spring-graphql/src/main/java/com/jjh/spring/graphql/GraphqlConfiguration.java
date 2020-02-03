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
	public BookResolver bookQueryResolver(AuthorDAO authorDao) {
		return new BookResolver(authorDao);
	}

	@Bean
	public AuthorResolver authorQueryResolver(BookDAO postDao) {
		return new AuthorResolver(postDao);
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
