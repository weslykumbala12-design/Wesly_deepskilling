package com.cognizant.spring_learn.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Facebook stocks in September 2019
    List<Stock> findByCodeAndDateBetween(
            String code,
            LocalDate startDate,
            LocalDate endDate);

    // Google stocks with close price > given value
    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            BigDecimal price);

    // Top 3 highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Lowest 3 Netflix stocks
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}