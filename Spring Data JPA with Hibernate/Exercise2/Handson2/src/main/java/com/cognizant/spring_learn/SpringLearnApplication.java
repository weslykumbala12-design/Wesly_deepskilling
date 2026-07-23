package com.cognizant.spring_learn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.spring_learn.model.Stock;
import com.cognizant.spring_learn.repository.StockRepository;

@SpringBootApplication
public class SpringLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        testFacebookStocks();

        testGoogleStocks();

        testHighestVolume();

        testLowestNetflixStocks();

    }

    private void testFacebookStocks() {

        LOGGER.info("Facebook Stocks - September 2019");

        List<Stock> stocks =
                stockRepository.findByCodeAndDateBetween(
                        "FB",
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 9, 30));

        stocks.forEach(stock -> LOGGER.debug("{}", stock));
    }

    private void testGoogleStocks() {

        LOGGER.info("Google Stocks > 1250");

        List<Stock> stocks =
                stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        new BigDecimal("1250"));

        stocks.forEach(stock -> LOGGER.debug("{}", stock));
    }

    private void testHighestVolume() {

        LOGGER.info("Top 3 Highest Volume");

        List<Stock> stocks =
                stockRepository.findTop3ByOrderByVolumeDesc();

        stocks.forEach(stock -> LOGGER.debug("{}", stock));
    }

    private void testLowestNetflixStocks() {

        LOGGER.info("Lowest 3 Netflix Stocks");

        List<Stock> stocks =
                stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");

        stocks.forEach(stock -> LOGGER.debug("{}", stock));
    }

}