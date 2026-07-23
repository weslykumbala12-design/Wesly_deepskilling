package com.cognizant.spring_learn.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="attempt")
public class Attempt {

    @Id
    @Column(name="at_id")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="at_date")
    private Date attemptedDate;

    @ManyToOne
    @JoinColumn(name="at_us_id")
    private User user;

    @OneToMany(mappedBy="attempt")
    private Set<AttemptQuestion> attemptQuestions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public Date getAttemptedDate() {
        return attemptedDate;
    }

    public void setAttemptedDate(Date attemptedDate) {
        this.attemptedDate=attemptedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions=attemptQuestions;
    }
}