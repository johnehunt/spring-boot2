package com.jjh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

    public BasicSecurityConfig() {
        System.out.println("BasicSecurityConfiguration.<init>()");
    }

    // Can also use the following method to set up a custom AuthenticationProvider
    // auth.authenticationProvider(new MyCustomAuthenticationProvider());
    // This must implement the AuthenticationProvider interface

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        System.out.println("BasicSecurityConfig.configure(auth)");
        auth.inMemoryAuthentication()
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
        System.out.println("BasicSecurityConfiq.configure(http)");

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/welcome/help").hasRole("USER")
                .antMatchers("/welcome/hello").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login");
    }
}



