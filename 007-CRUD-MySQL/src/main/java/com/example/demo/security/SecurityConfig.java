package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	private UserPrincipalDetailService userPrincipalDetailService;

	public SecurityConfig(UserPrincipalDetailService userPrincipalDetailService) {
		// TODO Auto-generated constructor stub
		this.userPrincipalDetailService = userPrincipalDetailService;
	}
	
	//authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
				/*
				 * .inMemoryAuthentication()
				 * .withUser("visitor").password("{noop}visitor1234").roles("VISITOR") .and()
				 * .withUser("manager").password("{noop}manager1234").roles("VISITOR",
				 * "MANAGER") .and()
				 .withUser("admin").password("{noop}admin1234").roles("VISITOR", "MANAGER", "ADMIN");
		*/
		
	}

	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.DELETE, "/friends/**").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/frends/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/friends/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers(HttpMethod.GET, "/friends/**").hasAnyRole("VISITOR", "MANAGER", "ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf()
			.disable();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailService);
		
		return daoAuthenticationProvider;
		
	}
	
	

}
