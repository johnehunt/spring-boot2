package com.jjh.writing;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class BioWriter implements Author {

    @Override
    public String getName() {
        return "Denise";
    }
}
