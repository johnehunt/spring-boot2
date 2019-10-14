package com.jjh.main2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyInfo {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Value("${spring.config.name}")
	String appName;
	
	public String getId() {
		return this.applicationContext.getId();
	}

}
