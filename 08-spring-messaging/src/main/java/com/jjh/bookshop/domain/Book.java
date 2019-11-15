package com.jjh.bookshop.domain;

import java.io.Serializable;

/**
 * Note the Book must be Serializable.
 * Data is being sent form one JVM to another so must be Seriliazable.
 */
public class Book implements Serializable {

	private static final long serialVersionUID = 1410531652155090037L;
	
	private String isbn;
	private String author;
	private String title;
	private double price;

	public Book() {
	}

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

	@Override
	public String toString() {
		return String.format("Book [id=%s, author=%s, title=%s, price=%s]", isbn, author, title, price);
	}

}
