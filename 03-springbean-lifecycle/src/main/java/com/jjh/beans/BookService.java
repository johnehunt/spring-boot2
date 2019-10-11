package com.jjh.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BookService {
	
	@Autowired
    private ApplicationContext ctx;
	
	@Autowired
	private BeanFactory beanFactory;
	
	@PostConstruct
	public void setupBookService() {
		System.out.println("BookService.setupBookService()");
	}
	
	@PreDestroy
	public void clearBookService() {
		System.out.println("BookService.clearBookService()");
	}

}
