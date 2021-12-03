package com.example.jpa_hibernate.repository;

import com.example.jpa_hibernate.entity.Course;
import com.example.jpa_hibernate.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id)
    {
        Course course = findById(id);
        em.remove(course);
    }

    // Insert or update
    public Course save(Course course)
    {
        if (course.getId() == null)
        {
            em.persist(course);
        }
        else
        {
            em.merge(course);
        }

        return course;
    }

    public void playWithEntityManager()
    {
        Course c1 = new Course("Angular Js");
        Course c2 = new Course("Typescript");
        em.persist(c1);
        em.persist(c2);

        c1.setName("React Js"); // This works for some reason

        em.flush();
        c1.setName("C# and .NET"); // flush defers changes
    }

    // Review is the owning side of the relationship
    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);

        for (Review review: reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }
}
