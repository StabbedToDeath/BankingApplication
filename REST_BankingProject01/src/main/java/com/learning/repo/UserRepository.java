package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
}
