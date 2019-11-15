package com.jjh.beans;

import org.springframework.stereotype.Component;

@Component
public class PrintService {
	
	public void print(String msg) {
		System.out.println(msg);
	}

}
