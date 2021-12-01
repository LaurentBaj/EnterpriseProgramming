package com.example.jpa_hibernate;

import com.example.jpa_hibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@SpringBootTest(classes = DemoApplication.class)
public class JpqlTest {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void findById()
    {
        Query query = em.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("Select c From c -> {}", resultList);
    }

    @Test
    public void ft()
    {
        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like 'JPA in 50 steps'", Course.class);
        List resultList = query.getResultList();
        logger.info("Select c From c -> {}", resultList);
    }
}
