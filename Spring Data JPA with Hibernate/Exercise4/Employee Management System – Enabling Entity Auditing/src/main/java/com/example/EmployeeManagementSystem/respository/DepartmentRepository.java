package com.example.EmployeeManagementSystem.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Derived Query Method
    List<Department> findByName(String name);

}