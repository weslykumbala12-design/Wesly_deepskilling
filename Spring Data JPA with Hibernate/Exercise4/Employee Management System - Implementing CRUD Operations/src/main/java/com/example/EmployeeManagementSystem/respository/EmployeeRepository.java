package com.example.EmployeeManagementSystem.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagementSystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Methods
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

}