package com.jjh.writing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Company {

    @Autowired
    private List<Author> authors;

    public void printAuthors() {
        for (Author author : authors) {
            System.out.println(author.getName());
        }
    }

}
