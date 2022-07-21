package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.CustomUserDetails;
import com.learning.entity.JWTRequest;
import com.learning.entity.JWTResponse;
import com.learning.service.CustomUserDetailsService;
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
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jwtRequest){
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		
		CustomUserDetails userDetails =  (CustomUserDetails) cudService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JWTResponse(token, userDetails.getRole()));
	}
	
}
