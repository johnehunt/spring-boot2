package com.jjh.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * Testing a Controller or Rest Controller by starting up
 * an embedded test application server and invoking services
 * via a rest template.
 */
@SpringBootTest(
        classes = com.jjh.main.Application.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerWebTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUserInJSONFormatForJohn() {
        String url = "http://localhost:" + port + "/users/user/John";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("John");
        assertThat(response).contains("54");
    }

    @Test
    public void getUsersShouldReturnJSONListOfUser() {
        String url = "http://localhost:" + port + "/users/list";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Bill");
        assertThat(response).contains("Ben");
    }

}
