package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.util.CountryUtil;

@Service
public class CountryService {

    private ArrayList<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryService() {
        ApplicationContext context = CountryUtil.getContext();
        countryList = (ArrayList<Country>) context.getBean("countryList");
    }

    public ArrayList<Country> getAllCountries() {
        return countryList;
    }
}