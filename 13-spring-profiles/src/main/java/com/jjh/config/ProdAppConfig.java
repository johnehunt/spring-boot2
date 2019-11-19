package com.jjh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("prod")
@ComponentScan("com.midmarsh.spring.beans")
@PropertySource("classpath*:prod-myprops.properties")
public class ProdAppConfig {

	@Autowired
	Environment env;

	@Bean
	public String name() {
		return "John Prod";
	}

}
