package com.minds.lms.springboot2jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minds.lms.springboot2jpacrud.model.Course;
import com.minds.lms.springboot2jpacrud.model.DataOrg;
import com.minds.lms.springboot2jpacrud.model.MultiDataCont;

@Repository
public interface MultiOrgDataRepository extends JpaRepository<DataOrg, Long> {



}
