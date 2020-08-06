package com.jjh.message;

import org.springframework.stereotype.Component;

@Component("MessageService")
public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService() {
		this("Welcome");
	}
	
	public DefaultMessageService(String msg) {
		System.out.println("DefaultMessageService.<init>(" + msg + ")");
		message = msg;
	}

	public String getMessage() {
		System.out.println("DefaultMessageService.getMessage()");
		return message;
	}

}
