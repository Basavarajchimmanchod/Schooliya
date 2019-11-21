package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minds.lms.springboot2jpacrud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public List<Role> findByRoleIdAndRoleNameAndOrganization(long roleid, String rolename , String organization);
	
}
