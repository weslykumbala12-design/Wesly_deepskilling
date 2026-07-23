package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProduct(String cpu,
                                       Integer ram,
                                       Integer hardDisk,
                                       String os) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if(cpu != null)
            predicates.add(cb.equal(product.get("cpu"), cpu));

        if(ram != null)
            predicates.add(cb.equal(product.get("ram"), ram));

        if(hardDisk != null)
            predicates.add(cb.equal(product.get("hardDisk"), hardDisk));

        if(os != null)
            predicates.add(cb.equal(product.get("operatingSystem"), os));

        cq.select(product)
          .where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

}