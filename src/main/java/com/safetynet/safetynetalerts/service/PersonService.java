package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;



@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    private String name;


    public ArrayList<Person> getPersons() {
        ArrayList<Person> getPersonList = personRepository.personList();
        return getPersonList;
    }

    public ArrayList<Person> addPerson(Person person) {
        ArrayList<Person> addPersonList = personRepository.personList();
        addPersonList.add(person);
        return addPersonList;
    }

    public ArrayList<Person> deletePerson(Person person) {
        ArrayList<Person> deletePersonOfList = personRepository.personList();
        deletePersonOfList.remove(person);
        return deletePersonOfList;
    }

    public Person findPerson(String name) {
        ArrayList<Person> personName = personRepository.personList();
        for (int i = 0; i < personName.size(); i++) {
            if (personName.get(i).getFirstname().toLowerCase().contains(name)) {
                Person personFind = personName.get(i);
                return personFind;
            }
        }
        return findPerson(name);
    }

    public Person updatePerson(Person person,String name) {
        ArrayList<Person> updateAPerson = personRepository.personList();
        Person uPerson = findPerson(name);
        for (int i = 0; i < updateAPerson.size(); i++) {
            if (updateAPerson.get(i).getFirstname().contains(uPerson.getFirstname())) {
                updateAPerson.set(i, person);
                return person;
            }

        }
        return updatePerson(person,name);
    }

}