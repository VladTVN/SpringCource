package ru.tvn.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.tvn.springcourse.models.Person;
import ru.tvn.springcourse.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals((clazz));
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Person person = (Person) target;
//        Optional<Person> optionalPerson = peopleService.show(person.getEmail());
//        if (optionalPerson.isPresent() && optionalPerson.get().getId() != person.getId()){
//            errors.rejectValue("email", "", "This email is already taken");
//        }


    }
}
