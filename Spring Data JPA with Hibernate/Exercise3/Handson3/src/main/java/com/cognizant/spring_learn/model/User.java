package com.cognizant.spring_learn.model;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="us_id")
    private int id;

    @Column(name="us_name")
    private String name;

    @OneToMany(mappedBy="user")
    private Set<Attempt> attempts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(Set<Attempt> attempts) {
        this.attempts=attempts;
    }
}