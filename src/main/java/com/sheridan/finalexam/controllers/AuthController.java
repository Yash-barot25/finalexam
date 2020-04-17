package com.sheridan.finalexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.Role;
import com.sheridan.finalexam.model.User;
import com.sheridan.finalexam.repository.RoleRepository;
import com.sheridan.finalexam.repository.UserRepository;

@Controller
public class AuthController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;	
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}


	@GetMapping("/register")
	public String registerPage(User user,Model model) {
		model.addAttribute("roles", roleRepository.findAllByNameNot(Roles.ADMIN));
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "redirect:/login";
	}

}
