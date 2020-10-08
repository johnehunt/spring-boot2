package com.jjh.service;

import com.jjh.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    private List<User> users = new ArrayList<User>();

    public UserService() {
        System.out.println("UserService.<cons>()");
        User user = new User("Bill", 30);
        users.add(user);
        user = new User("Ben", 28);
        users.add(user);
    }

    public List<User> getUsers() {
        System.out.println("UserService.getUsers()");
        return users;
    }

    public User getUser(String name) {
        System.out.println("UserService.getUser(" + name + ")");
        return new User(name, 54);
    }


}
