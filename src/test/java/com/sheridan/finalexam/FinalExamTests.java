package com.sheridan.finalexam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sheridan.finalexam.model.User;
import com.sheridan.finalexam.repository.UserRepository;

@SpringBootTest
class FinalExamTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void intialAdminShouldBeFound() {
		String adminEmail = "admin@sheridan.com";
		User found = userRepository.findByEmail(adminEmail);
		assertThat(found.getEmail()).isEqualTo(adminEmail);
	}

}
