package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}