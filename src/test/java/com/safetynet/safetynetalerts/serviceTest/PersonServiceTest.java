package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;



public class PersonServiceTest {

   private  PersonRepository personRepository = new PersonRepository();
   private PersonService personService = new PersonService();
   private Person person;






    @Test
    public void getPersons(){
        ArrayList<Person> personList = personRepository.personList();
            assertEquals(personList.size(), 23);
    }

    @Test
    public void addPerson(){
        person = new Person("tonton","tutu","00 tt 00","Paris","99999","00000000","mmm@nnn");
        ArrayList<Person> addPersonList = personService.addPerson(person);
            assertEquals(addPersonList.size(), 24);
   }

   @Test
    public void deletePerson(Person person){
        addPerson();
        personService.deletePerson(person);
        ArrayList<Person> personList = personRepository.readPersonList();
        assertEquals(personList.size(), 23);
   }

}
