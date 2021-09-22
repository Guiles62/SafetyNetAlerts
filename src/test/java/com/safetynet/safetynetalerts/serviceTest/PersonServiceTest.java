package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonServiceTest {

    private static PersonRepository personRepository;
    private static PersonService personService;
    private Person person;


    @BeforeAll
    private static void setUp() {

        personRepository = new PersonRepository();
        personService = new PersonService();
    }
    @BeforeEach
    private void setUpPerTest(){
        person = new Person("tonton","tutu","00 tt 00","Paris","99999","00000000","mmm@nnn");
    }


    @Test
    public void getPersons(){
        ArrayList<Person> personList = personRepository.readPersonList();
            assertEquals(personList.size(), 23);

    }

    @Test
    public void addPerson(){
        ArrayList<Person> personList = personRepository.readPersonList();
        personService.addPerson(person);
        for (int i=0; i<personList.size();i++){
            assertTrue(personList.get(i).getFirstname().contains("tonton"));
        }


    }
}
