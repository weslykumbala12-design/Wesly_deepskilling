package com.cognizant.spring_learn;

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

        getCountryTest();

        testAddCountry();

        testUpdateCountry();

        testDeleteCountry();
    }

    private void getCountryTest() {

        LOGGER.info("Start");

        Country country = countryService.findCountryByCode("IN");

        LOGGER.debug("Country : {}", country);

        LOGGER.info("End");
    }

    private void testAddCountry() {

        LOGGER.info("Start");

        Country country = new Country();

        country.setCode("NP");
        country.setName("Nepal");

        countryService.addCountry(country);

        Country result = countryService.findCountryByCode("NP");

        LOGGER.debug("Country : {}", result);

        LOGGER.info("End");
    }

    private void testUpdateCountry() {

        LOGGER.info("Start");

        countryService.updateCountry("NP",
                "Federal Democratic Republic of Nepal");

        Country country = countryService.findCountryByCode("NP");

        LOGGER.debug("Country : {}", country);

        LOGGER.info("End");
    }

    private void testDeleteCountry() {

        LOGGER.info("Start");

        countryService.deleteCountry("NP");

        LOGGER.info("Country Deleted");

        LOGGER.info("End");
    }

}