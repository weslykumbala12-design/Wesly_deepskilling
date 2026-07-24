package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.util.EmployeeUtil;

@Repository
public class DepartmentDao {

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {

        ApplicationContext context = EmployeeUtil.getContext();

        DEPARTMENT_LIST =
                (ArrayList<Department>) context.getBean("departmentList");
    }

    public ArrayList<Department> getAllDepartments() {

        return DEPARTMENT_LIST;
    }
}