package com.sheridan.finalexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sheridan.finalexam.repository.UserRepository;

@Component
public class Test implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {

	}

	public void encode() {
		System.out.println(passwordEncoder.encode("admin"));
	}

	@Override
	public void run(String... args) throws Exception {
		main(args);
		encode();

	}

}
