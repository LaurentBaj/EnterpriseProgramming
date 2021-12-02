package com.example.jpa_hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Passport passport;

    public Student() {}
    public Student(String name)
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
        return String.format("Student[%s]", name);
    }
}
