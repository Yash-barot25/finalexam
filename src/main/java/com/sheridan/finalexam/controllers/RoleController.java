package com.sheridan.finalexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sheridan.finalexam.model.Role;
import com.sheridan.finalexam.repository.RoleRepository;

@RestController
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/get/roles")
	public List<Role> getRoles(){
		return roleRepository.findAll(); 
	}
}
