package com.jjh.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Resturant  implements FoodService {
    public void produceFood() {
        System.out.println("Resturant.produceFood");
    }
}
