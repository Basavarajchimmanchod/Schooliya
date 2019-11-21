package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.InstituteRole;
import com.minds.lms.springboot2jpacrud.model.Role;

public interface InstituteRoleRepository extends JpaRepository<InstituteRole, Long> {
	

	public List<InstituteRole> findByCodeAndNameAndLms(String code, String name, String lms);
	
}
