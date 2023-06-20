package ru.tvn.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.tvn.springcourse.models.Person;

import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;


    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select person from Person person", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Person personFromDB = session.get(Person.class,id);
        personFromDB.setEmail(updatedPerson.getEmail());
        personFromDB.setAge(updatedPerson.getAge());
        personFromDB.setName(updatedPerson.getName());
        personFromDB.setAddress(updatedPerson.getAddress());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person personForRemove = session.get(Person.class, id);
        session.remove(personForRemove);
    }

    @Transactional
    public Optional<Person> show(String email){
        Session session = sessionFactory.getCurrentSession();
        Person person = session.createQuery("select person from Person person where person.email=:email", Person.class)
                .setParameter("email",email).getSingleResultOrNull();
        return Optional.ofNullable(person);
    }

}
