package com.jjh.websockets;

public class MessageRequest {

	private String name;

	public MessageRequest() {
	}

	public MessageRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
