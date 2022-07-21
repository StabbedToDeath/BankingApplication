package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.User;
import com.learning.repo.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;
	
	@Override
	public void addUser(User user) {
		repo.save(user);
	}

	@Override
	public User getUser(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<User> getAll() {
		return repo.findAll();
	}


	@Override
	public User getUserByUsername(String username) {
		return repo.findByUsername(username);
	}

}
