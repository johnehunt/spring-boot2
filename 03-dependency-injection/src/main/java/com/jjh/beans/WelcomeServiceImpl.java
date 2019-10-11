package com.jjh.beans;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

@Component
public class WelcomeServiceImpl implements WelcomeService {
	
	@Autowired
	private DateFormatter formatter;
	
	private MessageService messageService;
	
	public WelcomeServiceImpl() {
		System.out.println("WelcomeServiceImpl.<cons>()");
	}

	public String getWelcomeInfo(String user, Date date) {
		String msg = this.messageService.getMessage(user);
		return msg + " it is " + formatter.print(date, Locale.UK);
	}

	@Autowired
	@Qualifier("MyMessageService")
	public void setMessageService(MessageService service) {
		System.out.println("WelcomeServiceImpl.setMessageService(" + service + ")");
		this.messageService = service;
	}

}
