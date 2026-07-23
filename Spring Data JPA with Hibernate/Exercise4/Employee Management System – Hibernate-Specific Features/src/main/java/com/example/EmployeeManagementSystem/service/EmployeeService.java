package com.example.EmployeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.respository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployees(List<Employee> employees){
        employeeRepository.saveAll(employees);
    }
}
