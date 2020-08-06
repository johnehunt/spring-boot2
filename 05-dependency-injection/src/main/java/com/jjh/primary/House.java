package com.jjh.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class House {

    @Autowired
    private FoodService foodService;

    public void supplyFood() {
        foodService.produceFood();
    }
}
