package com.jjh.bookshop.main;

import org.springframework.jms.annotation.JmsListener;

import com.jjh.bookshop.domain.Book;

public class Receiver {

	@JmsListener(destination = "BookQueue")
	public void receive(Book message) {
		System.out.println("received message: " + message);
	}

}
