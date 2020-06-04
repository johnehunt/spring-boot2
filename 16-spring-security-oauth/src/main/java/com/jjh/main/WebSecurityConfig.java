package com.jjh.main;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.request.RequestContextListener;

// @EnableOAuth2Sso enables Single Sign on using OAUth2

@Configuration
@EnableOAuth2Sso
@ComponentScan(basePackages = "com.jjh.controller")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
   @Override
   public void configure(HttpSecurity http) throws Exception {
       http.antMatcher("/**")
         .authorizeRequests()
         .antMatchers("/", "/login**")
         .permitAll()
         .anyRequest()
         .authenticated();
   }
   
   @Bean
   public RequestContextListener requestContextListener() {
       return new RequestContextListener();
   }

}
