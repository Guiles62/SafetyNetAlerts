package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value ="person")
    public Iterable <Person> getPerson(){
        return personService.getPerson();
    }

    @GetMapping(value = "person/{id}")
    public Optional<Person> getPersonById(@PathVariable long id){
        Optional <Person> personById = personService.getPersonById(id);
        return personById;
    }

    @PostMapping(value ="person")
    public Person setPerson(Person person){
        return personService.savePerson(person);

    }
    @DeleteMapping(value = "person")
    public void deletePerson(long id){
        personService.deletePerson(id);
    }

}
