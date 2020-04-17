package com.sheridan.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.model.Booking;

public interface BookingRepository extends JpaRepository<Booking,Long>  {

}
