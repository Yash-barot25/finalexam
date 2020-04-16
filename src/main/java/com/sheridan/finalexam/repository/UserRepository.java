package com.sheridan.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
  
}