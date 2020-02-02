package com.jjh.spring.graphql;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;

public class BookResolver implements GraphQLResolver<Book> {
    private AuthorDao authorDao;

    public BookResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Book book) {
        return authorDao.getAuthor(book.getAuthorId());
    }
}
