package com.minds.lms.springboot2jpacrud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.minds.lms.springboot2jpacrud.exception.ResourceNotFoundException;

import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.Content;
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;

import com.minds.lms.springboot2jpacrud.repository.CategoryRepository;

import com.minds.lms.springboot2jpacrud.repository.FileRepository;
import com.minds.lms.springboot2jpacrud.repository.MultiDataRepository;


@RestController
@Repository
public class CategoryContentController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	@Autowired
	MultiDataRepository multidataRepository;
	
	

	/*@CrossOrigin
	@PostMapping("/addcategory")
public Category addCategoryContent(@RequestBody Category category ){
		 return categoryRepository.save(category);
	}
	*/
	
	 @CrossOrigin
	 @GetMapping("/allCategory")
	 
	    public List<Category> getAllContentFiles(@ModelAttribute Category category ) {
		 
		/* if(category.getContent() != null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(MultiDataCont t : category.getContent()) {
	                tagRepository.findAll();
	            }
	        }*/
	        return  categoryRepository.findAll();
	    }
	
	 @CrossOrigin
	    @GetMapping("/category/{id}")
	    public ResponseEntity<Category> getContentFilesById(@PathVariable(value = "id") Long categoryId)
	        throws ResourceNotFoundException {
	    	Category catmodel = categoryRepository.findById(categoryId)
	          .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	        return ResponseEntity.ok().body(catmodel);
	    }
	    
	 @CrossOrigin
	    @DeleteMapping("/category/{id}")
	    public Map<String, Boolean> deleteContent(@PathVariable(value = "id") Long categoryId)
	         throws ResourceNotFoundException {
	    	Category category = categoryRepository.findById(categoryId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + categoryId));
	    	categoryRepository.delete(category);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("Course Content File has deleted Successfully ", Boolean.TRUE);
	        return response;
	    }
		    
	    @CrossOrigin
	    @PutMapping("/category/{id}") 
	    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category catDetails ) throws ResourceNotFoundException, IOException {
	    	Category category = categoryRepository.findById(categoryId)
	        .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + categoryId));
	    	category.setName(catDetails.getName());
	    	category.setDescription(catDetails.getDescription());
	    	category.setLanguage(catDetails.getLanguage());;
	    	category.setLms(catDetails.getLms());
	    	category.setStartDate(catDetails.getStartDate());
	    	category.setEndDate(catDetails.getEndDate());
	    	category.setIsCategorySearchable(catDetails.getIsCategorySearchable());
	    	category.setContent(catDetails.getContent());
	       final  Category updateCategory = categoryRepository.save(category);
			return  ResponseEntity.ok(updateCategory);
	      
	    }
	    
	    @CrossOrigin
	    @GetMapping(value = "/searchCategory/{name}/{description}/{isCategorySearchable}")
	    public List<Category> findByNameAndDiscriptionAndSearchable(@PathVariable("name") String name,@PathVariable("discription") String description, @PathVariable("searchable") String isCategorySearchable ){
		return categoryRepository.findByNameAndDescriptionAndIsCategorySearchable(name, description ,isCategorySearchable);
	    }

	    
	    @CrossOrigin
	    @PostMapping("/addCategory")
	    public Category create(@RequestBody Category input) {
	        if(input.getContent() != null) {
	            //you are saving all the nested tags manually before saving the activity
	            for(MultiDataCont t : input.getContent()) {
	            	multidataRepository.save(t);
	            }
	        }
	        //now you are saving activity which contains these tags
	        return categoryRepository.save(input);
	    }
	    
		
	 
}