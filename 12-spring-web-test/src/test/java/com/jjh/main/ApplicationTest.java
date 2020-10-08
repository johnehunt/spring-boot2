package com.jjh.main;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    public void checkAllBeansLoaded() {
        int totalBeans = this.context.getBeanDefinitionCount();
        assertThat(totalBeans)
                .as("There should be 26 beans loaded")
                .isEqualTo(126);
    }

}