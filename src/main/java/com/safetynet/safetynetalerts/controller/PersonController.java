package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value ="/person")
    public Iterable <Person> getPerson(){
        return personService.getPerson();
    }
    @GetMapping(value = "/person/id")
    public Iterable <Person> getPersonById(long id){
        return personService.getPersonById();
    }
    @PostMapping(value ="/person")
    public Person setPerson(Person person){
        return personService.savePerson(person);

    }
    @DeleteMapping(value = "/person")
    public void deletePerson(long id){
        personService.deletePerson(id);
    }

}
