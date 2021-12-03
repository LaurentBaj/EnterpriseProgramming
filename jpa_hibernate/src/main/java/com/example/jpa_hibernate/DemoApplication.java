package com.example.jpa_hibernate;

import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.entity.Review;
import com.example.jpa_hibernate.repository.CourseRepository;
import com.example.jpa_hibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews =  new ArrayList<>();
		reviews.add(new Review("Awesome course!", "5"));
		reviews.add(new Review("Great lecture", "4"));
		repository.addReviewsForCourse(10003L, reviews);

		studentRepository.insertStudentAndCourse();
	}
}
