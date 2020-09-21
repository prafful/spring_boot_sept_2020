package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	
	//authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("visitor").password("{noop}visitor1234").roles("VISITOR")
		.and()
		.withUser("manager").password("{noop}manager1234").roles("VISITOR", "MANAGER")
		.and()
		.withUser("admin").password("{noop}admin1234").roles("VISITOR", "MANAGER", "ADMIN");
		
		
	}

	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/friends/**").hasAnyRole("VISITOR", "MANAGER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/friends/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/frends/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, "/friends/**").hasAnyRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}
	
	

}
