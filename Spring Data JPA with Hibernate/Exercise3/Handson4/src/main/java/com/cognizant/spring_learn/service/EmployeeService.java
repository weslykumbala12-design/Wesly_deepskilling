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

    public Employee get(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }
    

}