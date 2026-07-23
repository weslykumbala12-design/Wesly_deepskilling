package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}