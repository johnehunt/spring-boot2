package com.jjh.main2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Properties wil be auto-populated form the application.properties
 * default file - loaded by spring
 *
 * Will look for properties myapp.name and myapp.description
 */

@Component
@ConfigurationProperties(prefix="myapp")
public class MyAppProperties {
	
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
