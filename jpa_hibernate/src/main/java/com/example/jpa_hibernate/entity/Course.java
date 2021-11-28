package com.example.jpa_hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Course {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private String name;

    public Course() {}
    public Course(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
