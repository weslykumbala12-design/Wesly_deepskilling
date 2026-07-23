package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}