package com.jjh.hello2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.jjh.beans.SampleBean;

@ImportResource({ "classpath*:bean-context2.xml" })
@SpringBootApplication
public class HelloApplication2 {

	public static void main(String[] args) {
		System.out.println("Main - obtaining Application Context");
		ConfigurableApplicationContext context = SpringApplication.run(HelloApplication2.class, args);

		System.out.println("main - Requesting bean");
		SampleBean bean = context.getBean(SampleBean.class);
		System.out.println("bean: " + bean);
		System.out.println("context.stop()");
		context.stop();
		System.out.println("context.start()");
		context.start();
		System.out.println("main - Closing application context");
		context.close();
	}

}
