package com.jjh.controller;

import com.jjh.domain.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing a Controller or Rest Controller by starting up
 * an embedded test application server and invoking services
 * via a rest template.
 */
@SpringBootTest(
        classes = com.jjh.main.Application.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerWebTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    public void checkForUnauthorizedAccess401() throws Exception {
        String url = "http://localhost:" + port + "/users/list";
        String response = restTemplate
                .getForObject(url, String.class);
        assertThat(response).contains("401");
    }

    // Can't use @WithMockUser with rest template

    @Test
    @Order(2)
    public void getUserInJSONFormatForJohn() {
        String url = "http://localhost:" + port + "/users/user/John";
        String response = restTemplate
                .withBasicAuth("user", "user123")
                .getForObject(url, String.class);
        assertThat(response).contains("John");
        assertThat(response).contains("54");
    }

    @Test
    @Order(3)
    public void getUsersShouldReturnJSONListOfUser() {
        String url = "http://localhost:" + port + "/users/list";
        String response = restTemplate
                .withBasicAuth("user", "user123")
                .getForObject(url, String.class);
        assertThat(response).contains("Bill");
        assertThat(response).contains("Ben");
    }

    @Test
    @Order(4)
    public void testAddingNewUser() {
        String url = "http://localhost:" + port + "/users";
        User user = new User("4", "Denise", 53);
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<String> response = this.restTemplate
                .withBasicAuth("admin", "admin123")
                .postForEntity(url, request, String.class);
        assertThat(response.toString()).contains("201");
    }

}
