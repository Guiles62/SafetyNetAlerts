package com.safetynet.safetynetalerts.service;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;


@Service
public class PersonService {


    private PersonRepository personRepository;
    private Person person;



    public Optional<Person> getPersonById(final Long id) {
        return personRepository.findById(id);
    }

    public Iterable<Person> getPerson() {
        personRepository.personList();
        return getPerson();
    }

    public void deletePerson(Person person) {

        personRepository.delete(person);
    }

    public Person savePerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }

}
