package com.cognizant.spring_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.spring_learn.model.Attempt;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("SELECT DISTINCT a FROM Attempt a "
         + "JOIN FETCH a.user u "
         + "JOIN FETCH a.attemptQuestions aq "
         + "JOIN FETCH aq.question q "
         + "JOIN FETCH q.optionList o "
         + "LEFT JOIN FETCH aq.attemptOptions ao "
         + "LEFT JOIN FETCH ao.option "
         + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId,
                       @Param("attemptId") int attemptId);

}