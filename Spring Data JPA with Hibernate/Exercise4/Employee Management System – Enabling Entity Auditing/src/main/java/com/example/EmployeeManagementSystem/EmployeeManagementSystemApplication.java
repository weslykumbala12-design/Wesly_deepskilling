package com.example.EmployeeManagementSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.EmployeeManagementSystem.respository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println(employeeRepository.findByName("John"));

        System.out.println(employeeRepository.findByEmail("john@gmail.com"));

        System.out.println(employeeRepository.getEmployeeByName("John"));

        System.out.println(employeeRepository.getEmployeeByEmail("john@gmail.com"));
    }
}