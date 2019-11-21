package com.minds.lms.springboot2jpacrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "employeeTest")
@SecondaryTable(name = "employee_details")
public class EmployeeEntity 
{
   @Id
   @GeneratedValue (strategy = GenerationType.SEQUENCE)
   private Integer employeeId;
   private String  firstName;
   private String  lastName;
 
   @Column(table = "employee_details")
   public String address;
}