
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
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;
import com.minds.lms.springboot2jpacrud.model.Role;
import com.minds.lms.springboot2jpacrud.repository.MultiOrgDataRepository;
import com.minds.lms.springboot2jpacrud.repository.RoleRepository;





@RestController
public class SystemRoleController {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	MultiOrgDataRepository  multiOrgRepo;
	
	@CrossOrigin
	 @GetMapping("/roles")
	    public List<Role> getAllSystemRoles() {
	        return roleRepository.findAll();
	    }
	
	
	@CrossOrigin
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException{		
		
		Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));		

		return ResponseEntity.ok().body(role);
	}
	
	@CrossOrigin
    @PostMapping("/addRole")
    public Role create(@RequestBody Role input) {
        if(input.getOrganization() != null) {
            //you are saving all the nested tags manually before saving the activity
            for(DataOrg t : input.getOrganization()) {
            	multiOrgRepo.save(t);
            }
        }
        //now you are saving activity which contains these tags
        return roleRepository.save(input);
    }
	
	@CrossOrigin
	@DeleteMapping("role/{id}")
	public String deleteSystemRoles(@PathVariable(value ="id") long id){
		
		roleRepository.deleteById(id);
		
		return "Deleted" ;
		
	}
	
	@CrossOrigin
	@PutMapping("roles/{id}")
	public ResponseEntity<Role> updateSystemRoles(@PathVariable (value = "id") long id , @RequestBody Role roledetails) throws ResourceNotFoundException{
		
		Role role = roleRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User not found for this id : "+id)));
		
		
		role.setRoleName(roledetails.getRoleName());
		role.setOrganization(roledetails.getOrganization());
		role.setLanguage(roledetails.getLanguage());
		role.setEffectiveDate(roledetails.getEffectiveDate());
		role.setEndDate(roledetails.getEndDate());
		
		
		Role updaterole = roleRepository.save(role);
		
		return ResponseEntity.ok(updaterole);
		
	}
	
	@CrossOrigin
	@GetMapping("searchroles/{roleid}/{rolename}/{organisation}")
	
	public List<Role> findByRoleIdAndRoleNameAndOrganization(@PathVariable(value = "roleid") long roleid ,@PathVariable(value = "rolename") String rolename,@PathVariable(value = "organisation") String organization ){
		
		return roleRepository.findByRoleIdAndRoleNameAndOrganization(roleid,rolename,organization);
		
	
		
	}
	
	
	
	
	
	
	
}
