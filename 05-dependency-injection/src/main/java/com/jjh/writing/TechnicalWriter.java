package com.jjh.writing;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TechnicalWriter implements Author {

    @Override
    public String getName() {
        return "John";
    }
}
