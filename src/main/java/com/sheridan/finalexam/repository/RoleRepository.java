package com.sheridan.finalexam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheridan.finalexam.enums.Roles;
import com.sheridan.finalexam.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(Roles role);
	
	List<Role> findAllByNameNot(Roles role);
}
