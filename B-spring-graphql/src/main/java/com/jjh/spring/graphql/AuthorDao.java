package com.jjh.spring.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDao {
    private List<Author> authors;

    public AuthorDao() {
    	authors = new ArrayList<>();
		authors.add(new Author("1", "John"));
		authors.add(new Author("2", "Denise"));
		authors.add(new Author("3", "Paul"));
    }

    public Optional<Author> getAuthor(final String id) {
        return authors.stream().filter(author -> id.equals(author.getId())).findFirst();
    }
}
