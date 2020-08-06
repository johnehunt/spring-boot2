package com.jjh.bookshop.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.jjh.bookshop.domain.Book;

public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;
    private static final String destinationName = "BookQueue";

    public void send(Book book) {
        System.out.println("sending message: " + book);
        jmsTemplate.convertAndSend(destinationName, book);
    }

}
