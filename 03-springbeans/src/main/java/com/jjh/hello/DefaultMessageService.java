package com.jjh.hello;

import org.springframework.stereotype.Component;

@Component("MessageService")
public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService() {
		this("Welcome");
	}
	
	public DefaultMessageService(String msg) {
		System.out.println("DefaultMessageService.<cons>(" + msg + ")");
		message = msg;
	}

	public String getMessage() {
		System.out.println("DefaultMessageService.getMessage()");
		return message;
	}

}
