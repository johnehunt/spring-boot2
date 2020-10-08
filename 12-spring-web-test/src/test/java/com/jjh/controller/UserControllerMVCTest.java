package com.jjh.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing a controller or rest controller via
 * the MVC infrastructure
 */
@SpringBootTest(classes = com.jjh.main.Application.class)
@AutoConfigureMockMvc
public class UserControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserForJohnViaMVC() throws Exception {
        String urlTemplate = "/users/user/John";
        mockMvc.perform(get(urlTemplate))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("John")))
                .andExpect(content()
                        .string(containsString("54")));
    }

    @Test
    public void getTwoUsersListInJSON() throws Exception {
        String urlTemplate = "/users/list";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Bill")))
                .andExpect(content()
                        .string(containsString("Ben")));
    }

}
