package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.util.EmployeeUtil;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {

        ApplicationContext context = EmployeeUtil.getContext();

        EMPLOYEE_LIST =
                (ArrayList<Employee>) context.getBean("employeeList");
    }

    public ArrayList<Employee> getAllEmployees() {

        return EMPLOYEE_LIST;
    }

}