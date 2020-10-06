package com.jjh.init;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.jjh.app.HelloWorldWebApplication;

/**
 * Enables the web application to be deployed into a servlet container such as Tomcat
 * via a War file.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelloWorldWebApplication.class);
	}

}
