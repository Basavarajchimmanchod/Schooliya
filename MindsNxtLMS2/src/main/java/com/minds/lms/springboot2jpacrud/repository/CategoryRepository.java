package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minds.lms.springboot2jpacrud.model.Category;


@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
	
	public List<Category> findByNameAndDescriptionAndIsCategorySearchable(String name , String description, String isCategorySearchable);

	public Optional<Category> findById(Long categoryId);
	
	List<Category> findAll();

	
		
	

}
