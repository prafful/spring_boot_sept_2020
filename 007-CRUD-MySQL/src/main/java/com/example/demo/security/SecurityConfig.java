package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private UserPrincipalDetailService userPrincipalDetailService;

	/*
	 * public SecurityConfig(UserPrincipalDetailService userPrincipalDetailService)
	 * { // TODO Auto-generated constructor stub this.userPrincipalDetailService =
	 * userPrincipalDetailService; }
	 */
	
	//authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
				/*
				 * .inMemoryAuthentication()
				 * .withUser("visitor").password("{noop}visitor1234").roles("VISITOR") .and()
				 * .withUser("manager").password("{noop}manager1234").roles("VISITOR", "MANAGER") 
				 * .and()
				 .withUser("admin").password("{noop}admin1234").roles("VISITOR", "MANAGER", "ADMIN");
		*/
		
	}

	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/get/**").hasAnyRole("VISITOR", "MANAGER", "ADMIN")
			.antMatchers("/update/**").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/add").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/delete/**").hasAnyRole("ADMIN")
			.antMatchers("/welcome").permitAll()
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
		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailService);
		
		return daoAuthenticationProvider;
		
	}
	
	

}
