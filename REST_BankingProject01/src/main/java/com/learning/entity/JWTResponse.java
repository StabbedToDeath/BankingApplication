package com.learning.entity;

public class JWTResponse {
	
	private String token;
	private String role;

	public JWTResponse(String token, String role) {
		super();
		this.token = token;
		this.role = role;
	}

	public JWTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	 public String getRole() { return role; }
	 
	 public void setRole(String role) { this.role = role; }

	
	
	
	
}
