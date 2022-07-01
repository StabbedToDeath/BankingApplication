package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
