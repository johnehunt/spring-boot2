package com.jjh.main3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MessageService {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ResourceLoader resourceLoader;


    @PostConstruct
    public void setupBookService() {
        System.out.println("MessageService.setupBookService()");
    }
    @PreDestroy
    public void clearBookService() {
        System.out.println("MessageService.clearBookService()");
    }


    public void close() {
        System.out.println("MessageService.close()");
    }
    public void shutdown() {
        System.out.println("MessageService.shutdown()");
    }
}
