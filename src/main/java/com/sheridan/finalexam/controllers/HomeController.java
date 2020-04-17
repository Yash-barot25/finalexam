package com.sheridan.finalexam.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.User;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHomePage() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user.getRole().getName() == Roles.ADMIN) {
			return "redirect:/list-bookings";
		} else {
			return "redirect:/booking";
		}
	}
}
