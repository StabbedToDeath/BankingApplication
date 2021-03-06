package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.CustomUserDetails;
import com.learning.entity.JWTRequest;
import com.learning.entity.JWTResponse;
import com.learning.service.CustomUserDetailsService;
import com.learning.service.UserService;
import com.learning.util.JWTUtil;

@RestController
@CrossOrigin
public class JWTController {
	
	@Autowired
	//@Lazy
	AuthenticationManager authenticationManager;

	@Autowired
	CustomUserDetailsService cudService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserService uService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest){
		
		System.out.println("Im here");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		try {
			System.out.println(jwtRequest.getUsername());
			CustomUserDetails userDetails =  (CustomUserDetails) cudService.loadUserByUsername(jwtRequest.getUsername());
			
			String token = jwtUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new JWTResponse(token, uService.getUserByUsername(userDetails.getUsername()).getUserId(),  userDetails.getRole()));
			
		} catch (UsernameNotFoundException e) {
			return new ResponseEntity<String>("Invalid Token", HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
}	
