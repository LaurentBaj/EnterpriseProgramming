package com.example.jpa_hibernate;

import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository repository;

    @Test
    public void findById()
    {
        Course course = repository.findById(10001L);
        assertEquals(course.getName(), "JPA in 50 steps");
    }



    @Test
    @DirtiesContext  // Reset data after deletion
    public void deleteById()
    {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    public void insert_or_update()
    {
        // Test Insert
        Course course = new Course("Learn to love");
        repository.save(course);
        assertEquals("Learn to love", course.getName());

        // Test Update
        course.setName("Learn Kotlin");
        repository.save(course);
        assertEquals("Learn Kotlin", repository.findById(course.getId()).getName());
    }
}
