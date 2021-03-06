package com.example.jpa_hibernate.entity;

import javax.persistence.*;

@Entity
public class Review {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String rating;
    private String description;

    @ManyToOne
    private Course course;

    public Review() {}
    public Review(String description, String rating)
    {
        this.rating = rating;
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]", description, rating);
    }
}
