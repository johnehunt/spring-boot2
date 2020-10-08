package com.jjh.controller;

import com.jjh.domain.User;
import com.jjh.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing a controller in isolation - by mocking out service
 * it uses.
 */
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = com.jjh.main.Application.class)
public class UserControllerMockServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void getUserForJohnViaMVC() throws Exception {
        // Set up mocking behaviour for getUser
        when(service.getUser(any(String.class))).thenReturn(new User("John", 54) );
        String urlTemplate = "/users/user/John";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("John")))
                .andExpect(content()
                        .string(containsString("54")));

    }

}
