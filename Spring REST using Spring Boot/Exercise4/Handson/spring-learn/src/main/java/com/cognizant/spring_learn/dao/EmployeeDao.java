package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.util.EmployeeUtil;

@Repository
public class EmployeeDao {

    private ArrayList<Employee> employeeList;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = EmployeeUtil.getContext();
        employeeList = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee updateEmployee(int id, Employee employee) {

        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).getId() == id) {

                employee.setId(id);
                employeeList.set(i, employee);
                return employee;
            }
        }

        throw new EmployeeNotFoundException("Employee not found");
    }

    public void deleteEmployee(int id) {

        Employee employee = null;

        for (Employee emp : employeeList) {

            if (emp.getId() == id) {
                employee = emp;
                break;
            }
        }

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        employeeList.remove(employee);
    }
}