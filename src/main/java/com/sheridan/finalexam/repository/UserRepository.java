package com.sheridan.finalexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	List<User> findAllByRole_Name(Roles name); 
  
}