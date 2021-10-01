package com.jjh.main3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.out.println("Starting");
        System.out.println("Obtaining Application Context");
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        MessageService ms = context.getBean(MessageService.class);
        System.out.println(ms);
        context.close();
        System.out.println("Done");
    }
}
