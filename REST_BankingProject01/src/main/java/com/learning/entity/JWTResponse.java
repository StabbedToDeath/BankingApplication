package com.learning.entity;

public class JWTResponse {
	
	private String token;
	private String role;
	private int username;

	public JWTResponse(String token, int username, String role) {
		super();
		this.token = token;
		this.role = role;
		this.username = username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}
	
	
	
	
	
	
}
