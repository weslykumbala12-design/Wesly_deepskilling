package com.example.EmployeeManagementSystem.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived Query Methods
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

    // @Query Annotation
    @Query("SELECT e FROM Employee e WHERE e.name=:name")
    List<Employee> getEmployeeByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.email=:email")
    List<Employee> getEmployeeByEmail(@Param("email") String email);

}