package com.jjh.mircoservcies.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@ComponentScan(useDefaultFilters=false)  // Disable component scanner
public class ShopService {
	
	public static final String USER_SERVICE_URL = "http://book-service";
	
	public static void main(String[] args) {
		System.out.println("Starting the BookShop Service");
        // Will configure using web-server.yml
        System.setProperty("spring.config.name", "shop-service");
        SpringApplication.run(ShopService.class, args);
        System.out.println("Bookshop Service started");
    }
	
	@LoadBalanced    // Make sure to create the load-balanced template
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Account service calls microservice internally using provided URL.
     */
    @Bean
    public BookServiceDelegate bookService() {
        return new BookServiceDelegate(USER_SERVICE_URL);
    }

    @Bean
    public ShopController bookshopController() {
         return new ShopController
                       (bookService());  // plug in account-service
    }

}
