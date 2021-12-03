package com.example.jpa_hibernate;

import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.repository.CourseRepository;
import com.example.jpa_hibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
//		Course course = repository.findById(10001L);
//		logger.info("\nCourse 10001 {}\n", course);
//		repository.playWithEntityManager();

		studentRepository.saveStudentWithPassport();
	}
}
