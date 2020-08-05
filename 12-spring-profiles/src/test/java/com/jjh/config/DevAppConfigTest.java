package com.jjh.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath*:*Context.xml")
@ActiveProfiles("dev")
class DevAppConfigTest {

    @Autowired
    String name;

    @Autowired
    String info;

    @Test
    public void doDevAppTest() {
        assertNotNull(name);
        assertNotNull(info);
    }

}