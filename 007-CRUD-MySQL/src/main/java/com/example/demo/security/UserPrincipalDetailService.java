package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserPrincipalDetailService implements UserDetailsService {
	
	
	private UserRepository userRepository;
	
	public UserPrincipalDetailService(UserRepository userRepository) {
	// TODO Auto-generated constructor stub
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		
		// TODO Auto-generated method stub
		return userPrincipal;
	}



}
