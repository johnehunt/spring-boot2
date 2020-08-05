package com.jjh.main2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyInfo {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Value("${spring.config.name}")
	String appName;
	
	public String getId() {
		return this.applicationContext.getId();
	}
	
	public String getConfigLocation() {
		return this.env.getProperty("spring.config.location");
	}

}
