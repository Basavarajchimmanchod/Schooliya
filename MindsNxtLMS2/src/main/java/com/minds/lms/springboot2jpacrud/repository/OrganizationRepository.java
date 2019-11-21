package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.Organization;


@Transactional
@Repository
public interface OrganizationRepository extends JpaRepository<Organization,String>{
	
	

	
	
	List<Organization> findAll();

	Optional<Organization> findById(Long orgId);

	
		
	

}
