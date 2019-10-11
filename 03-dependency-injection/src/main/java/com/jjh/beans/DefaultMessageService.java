package com.jjh.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("MyMessageService")
public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService(@Value("Welcome") String msg) {
		System.out.println("DefaultMessageService.<cons>(" + msg + ")");
		message = msg;
	}

	public String getMessage(String name) {
		System.out.println("DefaultMessageService.getMessage(" + name + ")");
		return message + ": " + name;
	}

}
