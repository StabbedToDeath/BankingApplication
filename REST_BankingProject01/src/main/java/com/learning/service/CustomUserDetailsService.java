package com.learning.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.entity.CustomUserDetails;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserService uService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In Service");
		try {
			return new CustomUserDetails(uService.getUserByUsername(username));
		} catch (NullPointerException e) {
			throw new UsernameNotFoundException("Username nahi hain badwe");
		}
			
	}

}
