package com.cognizant.spring_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

}