package com.laurent.dev.databasedemo.jpa;

import com.laurent.dev.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

// Repository
// Transaction
@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager  entityManager;

    public List<Person> findAll()
    {
         TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
         return namedQuery.getResultList();
    }

    public Person findById(int id)
    {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person)
    {
        return entityManager.merge(person);
    }

    // No difference between an update or insert since merge() does the same
    public Person insert(Person person)
    {
        return entityManager.merge(person);
    }

    public void delete(int id)
    {
        Person person = findById(id);
        entityManager.remove(person);
    }
}
