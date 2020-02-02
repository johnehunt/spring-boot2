package com.jjh.spring.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
	@Bean
	public BookDao postDao() {
		List<Book> posts = new ArrayList<>();
		for (int bookId = 0; bookId < 3; ++bookId) {
			for (int authorId = 0; authorId < 3; ++authorId) {
				Book post = new Book();
				post.setIsbn(authorId + bookId + "");
				post.setTitle("Spring :" + bookId);
				post.setAuthorId(authorId + "");
				posts.add(post);
			}
		}
		return new BookDao(posts);
	}

	@Bean
	public AuthorDao authorDao() {
		List<Author> authors = new ArrayList<>();
		for (int authorId = 0; authorId < 3; ++authorId) {
			Author author = new Author();
			author.setId(authorId + "");
			author.setName("Author " + authorId);
			authors.add(author);
		}
		return new AuthorDao(authors);
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
	public Query query(BookDao postDao) {
		return new Query(postDao);
	}

	@Bean
	public Mutation mutation(BookDao postDao) {
		return new Mutation(postDao);
	}
}
