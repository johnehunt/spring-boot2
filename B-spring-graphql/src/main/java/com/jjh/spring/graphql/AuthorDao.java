package com.jjh.spring.graphql;

import java.util.List;
import java.util.Optional;

public class AuthorDao {
    private List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Optional<Author> getAuthor(final String id) {
        return authors.stream().filter(author -> id.equals(author.getId())).findFirst();
    }
}
