package com.jjh.bookshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jjh.bookshop.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {}