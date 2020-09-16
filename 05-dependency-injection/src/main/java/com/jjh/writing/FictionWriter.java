package com.jjh.writing;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class FictionWriter implements Author {

    @Override
    public String getName() {
        return "Adam";
    }
}