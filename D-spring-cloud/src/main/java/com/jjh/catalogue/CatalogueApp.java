package com.jjh.catalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogueApp {
	public static void main(String[] args) {
    	System.out.println("Starting the catalog service");
        SpringApplication.run(CatalogueApp.class, args);
        System.out.println("Startup complete");
    }
}
