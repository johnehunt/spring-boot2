package com.jjh.main;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		// Note the change - no SpringAPplication.run()
		SpringApplication app = new SpringApplication(App.class);
		app.setBanner(new MyBanner());
		app.setLogStartupInfo(false);
		app.run(args);
	}

//	// Can also use the Fluent API
//	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//		        .bannerMode(Banner.Mode.OFF)
//		        .sources(App.class)
//		        .logStartupInfo(false)
//		        .run(args);
//
//	}
	
//	// Can activate Profiles
//	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//		        .banner(new MyBanner())
//		        .sources(App.class)
//		        .logStartupInfo(true)  
//		        .profiles("prod")
//		        .run(args);
//
//	}
	
//	// Can activate Profiles
//	public static void main(String[] args) {
//		new SpringApplicationBuilder()
//		        .sources(App.class)
//		        .web(WebApplicationType.NONE) // Tell Spring boot not to use web components
//		        .run(args);
//
//	}
}

class MyBanner implements Banner {

	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		out.println("---------------------");
		out.println("  My Custom Banner");
		out.println("---------------------");
	}

}