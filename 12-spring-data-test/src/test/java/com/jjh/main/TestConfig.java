package com.jjh.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan(basePackages = {"com.jjh.main"})
@DataJpaTest
@PropertySource({"application.properties"})
public class TestConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassname;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

}

