package com.cognizant.spring_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.spring_learn.model.Country;
import com.cognizant.spring_learn.service.CountryService;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testSearchCountry();

        testSearchCountrySorted();

        testSearchCountryStartsWith();
    }

    private void testSearchCountry() {

        LOGGER.info("Search by partial name");

        List<Country> countries =
                countryService.searchCountries("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private void testSearchCountrySorted() {

        LOGGER.info("Search by partial name (Sorted)");

        List<Country> countries =
                countryService.searchCountriesSorted("ou");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

    private void testSearchCountryStartsWith() {

        LOGGER.info("Countries starting with Z");

        List<Country> countries =
                countryService.searchCountriesStartingWith("Z");

        countries.forEach(country -> LOGGER.debug("{}", country));
    }

}