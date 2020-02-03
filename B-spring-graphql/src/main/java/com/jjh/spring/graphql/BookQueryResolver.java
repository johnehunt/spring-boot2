package com.jjh.spring.graphql;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookQueryResolver implements GraphQLResolver<Book> {
    private AuthorDAO authorDao;

    public BookQueryResolver(AuthorDAO authorDao) {
        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Book book) {
    	System.out.println("BookQueryResolver.getAuthor(" + book + ")");
        return authorDao.getAuthor(book.getAuthorId());
    }
}
