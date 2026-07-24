package com.cognizant.spring_learn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeUtil {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("employee.xml");
    }

    public static ApplicationContext getContext() {
        return context;
    }
}