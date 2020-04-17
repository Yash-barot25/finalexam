package com.sheridan.finalexam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.Booking;
import com.sheridan.finalexam.model.User;
import com.sheridan.finalexam.repository.BookingRepository;
import com.sheridan.finalexam.repository.RoomRepository;

@Controller
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RoomRepository roomRepository;

	@ResponseBody
	@GetMapping("/rest-api/get/bookings")
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@GetMapping("/booking")
	public String bookingPage(Model model, Booking booking) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (booking.getId() == null) {
			if (user.getRole().getName() != Roles.ADMIN) {
				model.addAttribute("rooms", roomRepository.findAll());
				return "/booking";

			} else {
				return "redirect:/list-bookings";
			}
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("/make-booking")
	public String persistBooking(@ModelAttribute Booking booking, Model model, RedirectAttributes redirectAttributes) {
		boolean isNewBooking = booking.getId() == null;
		if (isNewBooking) {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			booking.setUser(user);
		}
		bookingRepository.save(booking);
		redirectAttributes.addFlashAttribute("booking", booking);
		if (isNewBooking) {
			return "redirect:/booking-successful";
		} else {
			return "redirect:/list-bookings";
		}
	}

	@GetMapping("/booking-successful")
	public String getBookingSuccessful(@ModelAttribute Booking booking) {
		return "/booking-successful";
	}

	@GetMapping("/list-bookings")
	public String getAllBookings(Model model) {
		model.addAttribute("bookings", bookingRepository.findAll());
		return "/list-booking";
	}

	@GetMapping("/edit/booking/{bookingId}")
	public String getEditBooking(Model model, @PathVariable Long bookingId) {
		model.addAttribute("rooms", roomRepository.findAll());
		model.addAttribute("booking", bookingRepository.findById(bookingId));
		return "/booking";
	}

	@GetMapping("/edit-booking/delete/{bookingId}")
	public String deleteBooking(Model model, @PathVariable Long bookingId) {
		bookingRepository.deleteById(bookingId);
		return "redirect:/list-bookings";
	}
}
