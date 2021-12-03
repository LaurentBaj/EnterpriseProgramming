package com.example.jpa_hibernate.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport() {}
    public Passport(String number)
    {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return String.format("Student[%s]", number);
    }
}
