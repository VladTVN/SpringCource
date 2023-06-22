package ru.tvn.springcourse.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tvn.springcourse.models.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDao {

@PersistenceContext
private EntityManager entityManager;

    @Transactional(readOnly = true)
    public void testNPlus1(){
       Session session = entityManager.unwrap(Session.class);
        Set<Person> personSet = new HashSet<>(session.createQuery("SELECT p from Person p left join fetch p.items", Person.class).getResultList());
        for (Person person: personSet) {
            System.out.println(person.toString() + ". Items: "+person.getItems().toString());
        }

    }

}
