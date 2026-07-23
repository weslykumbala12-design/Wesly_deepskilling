package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.spring_learn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}