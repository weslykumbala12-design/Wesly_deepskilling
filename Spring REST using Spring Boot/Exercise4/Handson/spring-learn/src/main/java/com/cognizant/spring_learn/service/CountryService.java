package com.cognizant.spring_learn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.exception.CountryNotFoundException;
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

    public Country getCountry(String code) {

        for (Country country : countryList) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException("Country not found");
    }

    public ArrayList<Country> getAllCountries() {
        return countryList;
    }
}