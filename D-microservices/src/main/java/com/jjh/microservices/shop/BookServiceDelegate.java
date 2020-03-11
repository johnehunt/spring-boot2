package com.jjh.microservices.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import com.jjh.microservices.books.Book;

@Component
public class BookServiceDelegate {

	public static final String USER_SERVICE_URL = "http://book-service";

	@Autowired // NO LONGER auto-created by Spring Cloud (see below)
	@LoadBalanced // Explicitly request the load-balanced template
	private RestTemplate restTemplate;

	public List<Book> getBooks() {
		List<Book> results = (List<Book>) restTemplate.getForObject(USER_SERVICE_URL, List.class);
		return results;
	}

}
