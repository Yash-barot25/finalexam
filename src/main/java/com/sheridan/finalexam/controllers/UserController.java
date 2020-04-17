package com.sheridan.finalexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.User;
import com.sheridan.finalexam.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	
	@ResponseBody
	@GetMapping("/get/users")
	public List<User> getCustomers(){
		return userRepository.findAllByRole_Name(Roles.ADMIN);
	}
}
