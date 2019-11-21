
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
import com.minds.lms.springboot2jpacrud.model.Discipline;
import com.minds.lms.springboot2jpacrud.model.InstituteRole;
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;
import com.minds.lms.springboot2jpacrud.model.Role;
import com.minds.lms.springboot2jpacrud.repository.DisciplineDataRepository;
import com.minds.lms.springboot2jpacrud.repository.InstituteRoleRepository;
import com.minds.lms.springboot2jpacrud.repository.MultiInstituteDataRepository;
import com.minds.lms.springboot2jpacrud.repository.MultiOrgDataRepository;
import com.minds.lms.springboot2jpacrud.repository.RoleRepository;





@RestController
public class DisciplineController {
	@Autowired
	DisciplineDataRepository disciplineRepository;
	@Autowired
	MultiInstituteDataRepository  multiInstRepo;
	
	@CrossOrigin
	 @GetMapping("/viewDisciplines")
	    public List<Discipline> getAllSystemRoles() {
	        return disciplineRepository.findAll();
	    }
	
	
	@CrossOrigin
	@GetMapping("/viewDiscipline/{id}")
	public ResponseEntity<Discipline> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Discipline role = disciplineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}
	
	@CrossOrigin
    @PostMapping("/addDiscipline")
    public Discipline create(@RequestBody Discipline input) {
        if(input.getOwnerOrganizations() != null) {
            //you are saving all the nested tags manually before saving the activity
            for(DataOrg t : input.getOwnerOrganizations()) {
            	multiInstRepo.save(t);
            }
        }
        //now you are saving activity which contains these tags
        return disciplineRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("deleteDiscipline/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		disciplineRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("upadateDiscipline/{id}")
	public ResponseEntity<Discipline> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Discipline roledetails) throws ResourceNotFoundException{
		
		Discipline role = disciplineRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setCode(roledetails.getCode());
		role.setOwnerOrganizations(roledetails.getOwnerOrganizations());
		role.setName(roledetails.getName());
		role.setLanguage(roledetails.getLanguage());
		role.setDescription(roledetails.getDescription());
		role.setOrdinal(roledetails.getOrdinal());
		role.setStatus(roledetails.getStatus());
			
		
		
		Discipline updaterole = disciplineRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchDiscipline/{code}/{name}")
	
	public List<Discipline> findByCodeAndName(@PathVariable(value = "code") String code ,@PathVariable(value = "name") String name){
		
		return disciplineRepository.findByCodeAndName(code,name);

	}	
	
	
	
	
	
	
	
}
