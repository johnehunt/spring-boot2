package com.jjh.microservices.users;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private List<User> users = Stream.of(new User(1, "John"), new User(2, "Paul")).collect(Collectors.toList());

	
	@GetMapping
	public List<User> getUsers() {
		System.out.println("UserService.getUsers() - " + users);
		return this.users;
	}
	
	@GetMapping
	public User getUser(int id) {
		return users.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
	}

}
