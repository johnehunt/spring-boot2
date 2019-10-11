package com.jjh.beans;

public class DefaultMessageService implements MessageService {
	
	private String message;
	
	public DefaultMessageService(String msg) {
		System.out.println("DefaultMessageService.<cons>(" + msg + ")");
		message = msg;
	}

	public String getMessage() {
		System.out.println("DefaultMessageService.getMessage()");
		return message;
	}

}
