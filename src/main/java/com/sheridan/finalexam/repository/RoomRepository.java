package com.sheridan.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.model.RoomType;

public interface RoomRepository extends JpaRepository<RoomType,Long> {

}
