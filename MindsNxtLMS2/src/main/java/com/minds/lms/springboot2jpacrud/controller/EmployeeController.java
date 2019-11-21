
package com.minds.lms.springboot2jpacrud.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minds.lms.springboot2jpacrud.exception.ResourceNotFoundException;
import com.minds.lms.springboot2jpacrud.model.Category;
import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.model.DataOrg;
import com.minds.lms.springboot2jpacrud.model.EmployeeEntity;
import com.minds.lms.springboot2jpacrud.model.InstituteRole;
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;
import com.minds.lms.springboot2jpacrud.model.Role;
import com.minds.lms.springboot2jpacrud.model.Term;
import com.minds.lms.springboot2jpacrud.repository.EmployeeRepository;
import com.minds.lms.springboot2jpacrud.repository.InstituteRoleRepository;
import com.minds.lms.springboot2jpacrud.repository.MultiInstituteDataRepository;
import com.minds.lms.springboot2jpacrud.repository.MultiOrgDataRepository;
import com.minds.lms.springboot2jpacrud.repository.RoleRepository;
import com.minds.lms.springboot2jpacrud.repository.TermRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepository;
	
	
	@CrossOrigin
	 @GetMapping("/viewEmp")
	    public List<EmployeeEntity> getAllTerms() {
	        return empRepository.findAll();
	    }
	
	/*
	@CrossOrigin(allowedHeaders = "*")
	@GetMapping("/viewTerm/{id}")
	public ResponseEntity<Term> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Term role = termRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}*/
	
	@CrossOrigin
    @PostMapping("/addEmployee")
    public EmployeeEntity create(@RequestBody EmployeeEntity input) {
           return empRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deletEmp/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		empRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	/*
	@CrossOrigin
	@PutMapping("updateTerm/{id}")
	public ResponseEntity<Term> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Term roledetails) throws ResourceNotFoundException{
		
		Term role = termRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setTermName(roledetails.getTermName());
		role.setTermDescription(roledetails.getTermDescription());
		role.setStartDate(roledetails.getStartDate());
		role.setLanguage(roledetails.getLanguage());
		role.setEndDate(roledetails.getEndDate());
		Term updaterole = termRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchTerm/{termName}")
	
	public List<Term> findByTerms(@PathVariable(value = "termName") String termName){
		
		return termRepository.findByTermName(termName);
	
	}	
	*/
	
	
	
	
	
	
}
