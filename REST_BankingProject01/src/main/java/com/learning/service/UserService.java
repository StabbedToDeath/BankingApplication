package com.learning.service;

import java.util.List;

import com.learning.entity.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(int id);
	
	public User getUserByUsername(String username);
	
	public List<User> getAll();
	
	
	
}
