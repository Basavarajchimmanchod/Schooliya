package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.EmployeeEntity;
import com.minds.lms.springboot2jpacrud.model.InstituteRole;
import com.minds.lms.springboot2jpacrud.model.Role;
import com.minds.lms.springboot2jpacrud.model.Term;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity save(EmployeeEntity input);
	


	
}
