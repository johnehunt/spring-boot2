package com.jjh.mircoservcies.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import com.jjh.microservices.books.Book;

public class BookServiceDelegate {

	@Autowired // NO LONGER auto-created by Spring Cloud (see below)
	@LoadBalanced // Explicitly request the load-balanced template
					// with Ribbon built-in
	private RestTemplate restTemplate;

	private String serviceUrl;

	public BookServiceDelegate(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public List<Book> getBooks() {
		List<Book> results = (List<Book>) restTemplate.getForObject(serviceUrl, List.class);
		return results;
	}

}
