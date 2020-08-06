package com.jjh.primary;

import org.springframework.stereotype.Component;

@Component
public class Takeaway implements FoodService {
    public void produceFood() {
        System.out.println("Takeaway.produceFood");
    }
}
