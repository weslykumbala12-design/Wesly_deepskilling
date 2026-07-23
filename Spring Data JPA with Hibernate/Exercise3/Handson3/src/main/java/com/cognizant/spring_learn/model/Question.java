package com.cognizant.spring_learn.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="question")
public class Question {

    @Id
    @Column(name="qt_id")
    private int id;

    @Column(name="qt_text")
    private String text;

    @OneToMany(mappedBy="question")
    private Set<Option> optionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text=text;
    }

    public Set<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(Set<Option> optionList) {
        this.optionList=optionList;
    }
}