package com.jjh.bookshop.domain;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException() {
	}

	public BookNotFoundException(String message) {
		super(message);
	}

}
