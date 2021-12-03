package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.entity.Passport;
import com.example.jpa_hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id)
    {
        Student student = findById(id);
        em.remove(student);
    }

    // Insert or update
    public Student save(Student student)
    {
        if (student.getId() == null)
        {
            em.persist(student);
        }
        else
        {
            em.merge(student);
        }

        return student;
    }

    public void saveStudentWithPassport()
    {
        Passport passport = new Passport("1234");
        em.persist(passport);

        Student student = new Student("Mike Hunt");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("Microservices");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        // Student is the owning side
        // We need only to persist the student
        em.persist(student);
    }
}
