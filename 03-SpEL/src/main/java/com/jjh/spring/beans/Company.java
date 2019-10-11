package com.jjh.spring.beans;

import org.springframework.stereotype.Component;

@Component("company")
public class Company {
	
	private String name = "My COmpany";

	public String getName() {
		return name;
	}

}
