package com.cognizant.spring_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department get(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

}