package com.jjh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("test")
@ComponentScan("com.midmarsh.spring.beans")
@PropertySource("classpath*:test-myprops.properties")
public class TestAppConfig {

	@Autowired
	Environment env;
	
	@Bean
	public String name() {
		return "John Test";
	}

}
