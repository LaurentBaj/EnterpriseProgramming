package com.example.jpa_hibernate;


import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.entity.Passport;
import com.example.jpa_hibernate.entity.Student;
import com.example.jpa_hibernate.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void retrieveStudentAndPassportDetails() {
        repository.saveStudentWithPassport();
    }

    @Test
    public void getStudentByPassword() {
        Passport passport = em.find(Passport.class, 1L);
        assertEquals("Mike Hunt", passport.getStudent().getName());
    }

    @Test
    @Transactional
    public void retrieveStudentsByCourses() {
        Course course = em.find(Course.class, 10001L);
        List<Student> studentList = course.getStudents();

        for (Student student : studentList){
            System.out.println(student);
        }
    }

}
