package com.jjh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

    public BasicSecurityConfiguration() {
        System.out.println("BasicSecurityConfiguration.<init>()");
    }

    // Can also use the following method to set up a custom AuthenticationProvider
    // auth.authenticationProvider(new MyCustomAuthenticationProvider());
    // This must implement the AuthenticationProvider interface

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        System.out.println("BasicSecurityConfiguration.configure(auth)");
        auth
                .inMemoryAuthentication()
                .withUser("jeh")
                .password("{noop}user123") // Otherwise expects encoded password
                .roles("USER") // Note  note ROLE automatically added to USER
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("BasicSecurityConfiguration.configure(http)");
        //HTTP Basic authentication - .antMatchers("/welcome/help/**")
        // Cross-Site Request Forgery protection turned on by default (see also .cors() Cross Origin Requests)
        // can turn off with .csrf().disable()

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/welcome/help").hasRole("USER")
                .antMatchers("/welcome/hello").hasRole("ADMIN");
    }
}



