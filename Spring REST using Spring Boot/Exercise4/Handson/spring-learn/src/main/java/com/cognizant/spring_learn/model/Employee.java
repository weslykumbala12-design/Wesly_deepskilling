package com.cognizant.spring_learn.model;

import java.util.Date;
import java.util.List;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;
    private Boolean permanent;
    private Department department;
    private List<Skill> skills;
    private Date dateOfBirth;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary,
                    Boolean permanent,
                    Department department,
                    List<Skill> skills,
                    Date dateOfBirth) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.department = department;
        this.skills = skills;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary="
                + salary + ", permanent=" + permanent + ", department="
                + department + ", skills=" + skills + ", dateOfBirth="
                + dateOfBirth + "]";
    }
}