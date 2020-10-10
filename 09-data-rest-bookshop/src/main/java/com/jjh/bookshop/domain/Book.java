package com.jjh.bookshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	// @GeneratedValue
	private String isbn;
	@NotBlank(message = "Author is mandatory")
	private String author;
	@NotBlank(message = "Title is mandatory")
	private String title;

	@Min(0)
	private double price;
	
	public Book() {}
	
	public Book(String isbn, String author, String title, double price) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, author=%s, title=%s, price=%s]", isbn, author, title, price);
	}
	
}
