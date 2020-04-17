package com.sheridan.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
