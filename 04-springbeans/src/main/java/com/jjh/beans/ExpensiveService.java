package com.jjh.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("MyService")
@Lazy(true)
public class ExpensiveService {
    public ExpensiveService() {
        System.out.println("ExpensiveService.<init.()");
    }
    public void doSomething() {
        System.out.println("ExpensiveService.doSomething()");
    }
}
