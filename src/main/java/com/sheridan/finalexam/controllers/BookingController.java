package com.sheridan.finalexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheridan.finalexam.model.Booking;
import com.sheridan.finalexam.repository.BookingRepository;

@Controller
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;
	
	@ResponseBody
	@GetMapping("/rest-api/get/bookings")
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	@PostMapping("/make-booking")
	public String persistBooking(@ModelAttribute Booking booking,Model model) {
		bookingRepository.save(booking);
		return "/booking";
	}
}
