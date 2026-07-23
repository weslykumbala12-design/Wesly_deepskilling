package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}