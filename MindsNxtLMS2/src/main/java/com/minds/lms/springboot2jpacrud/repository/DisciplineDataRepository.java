package com.minds.lms.springboot2jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.model.DataOrg;
import com.minds.lms.springboot2jpacrud.model.Discipline;
import com.minds.lms.springboot2jpacrud.model.InstituteRole;
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;

@Repository
public interface DisciplineDataRepository extends JpaRepository<Discipline, Long> {

	Discipline save(Discipline input);

	List<Discipline> findByCodeAndName(String code, String name);

	



}
