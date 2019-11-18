package com.jjh.bookshop.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.jjh.bookshop.domain.Book;

public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(Book message) {
		System.out.println("sending message: " + message);
		jmsTemplate.convertAndSend("BookQueue", message);
	}

}
