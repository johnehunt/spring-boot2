package com.jjh.bookshop.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

import com.jjh.bookshop.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private JmsTemplate jmsTemplate;

    @Value("${queue-name}")
    private String destinationName;

    @Autowired
    public Sender(JmsTemplate jmsTemplate) {
        System.out.println("Sender.<init>()");
        this.jmsTemplate = jmsTemplate;
    }

    public void send(Book book) {
        System.out.println("sending message: " + book + " to " + destinationName);
        jmsTemplate.convertAndSend(destinationName, book);
    }

}
