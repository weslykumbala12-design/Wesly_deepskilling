package com.cognizant.spring_learn.model;

import jakarta.persistence.*;

@Entity
@Table(name="options")
public class Option {

    @Id
    @Column(name="op_id")
    private int id;

    @Column(name="op_text")
    private String text;

    @Column(name="op_score")
    private float score;

    @ManyToOne
    @JoinColumn(name="op_qt_id")
    private Question question;

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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score=score;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question=question;
    }
}