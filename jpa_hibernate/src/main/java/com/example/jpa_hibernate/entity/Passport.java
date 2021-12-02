package com.example.jpa_hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Passport {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @Column(nullable = false)
    private String number;

    public Passport() {}
    public Passport(String number)
    {
        this.number = number;
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
