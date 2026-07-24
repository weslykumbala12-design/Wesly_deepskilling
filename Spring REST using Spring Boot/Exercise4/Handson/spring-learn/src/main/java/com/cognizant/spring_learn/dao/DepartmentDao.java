package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.util.EmployeeUtil;

@Repository
public class DepartmentDao {

    private ArrayList<Department> departmentList;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        ApplicationContext context = EmployeeUtil.getContext();
        departmentList = (ArrayList<Department>) context.getBean("departmentList");
    }

    public ArrayList<Department> getAllDepartments() {
        return departmentList;
    }
}