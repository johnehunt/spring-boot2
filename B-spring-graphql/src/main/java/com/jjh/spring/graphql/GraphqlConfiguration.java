package com.jjh.spring.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
	@Bean
	public BookDao postDao() {
		return new BookDao();
	}

	@Bean
	public AuthorDao authorDao() {
		return new AuthorDao();
	}

	@Bean
	public BookResolver postResolver(AuthorDao authorDao) {
		return new BookResolver(authorDao);
	}

	@Bean
	public AuthorResolver authorResolver(BookDao postDao) {
		return new AuthorResolver(postDao);
	}

	@Bean
	public Query query(BookDao bookDao) {
		return new Query(bookDao);
	}

	@Bean
	public Mutation mutation(BookDao bookDao) {
		return new Mutation(bookDao);
	}
}
