package com.cognizant.spring_learn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountryUtil {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("country.xml");
    }

    public static ApplicationContext getContext() {
        return context;
    }
}