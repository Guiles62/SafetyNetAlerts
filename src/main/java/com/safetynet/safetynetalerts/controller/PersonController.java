package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import com.safetynet.safetynetalerts.service.ReadDataFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;


@RestController
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    ReadDataFromService readDataFromService;


    @GetMapping(value ="person")
    public ArrayList<Person> getPersons(){
        ArrayList<Person> getPersonList = personService.getPersons();
        return getPersonList;
    }
    @GetMapping(value ="person/{name}")
    public Person getPerson(@PathVariable String name){
        Person person = personService.findPerson(name);
        return person;
    }
    @PostMapping(value ="person/addperson" )
    public ArrayList<Person> addPerson(@RequestBody Person person){
        ArrayList<Person> addPersonList = personService.addPerson(person);
        return addPersonList;
    }
    @PutMapping(value="person/{name}")
    public Person updatePerson(@RequestBody Person person,@PathVariable String name){
        Person uPerson = personService.updatePerson(person,name);
        return uPerson;
    }

    @DeleteMapping(value ="person")
    public ArrayList<Person> deletePerson(Person person){
        ArrayList<Person> deletePersonList = personService.deletePerson(person);
        return deletePersonList;
    }
    // donne la liste des mails des habitants de la ville
    @GetMapping(value = "communityEmail/{city}")
    public ArrayList<String> personsMail(@PathVariable String city){
        ArrayList<String> mailOfPersons = personService.getMailPersons(city);
        return mailOfPersons;
    }
    // donne les infos sur la médications de personnes
    @GetMapping(value = "personInfo/{lastname}")
    public ArrayList<String>personListMedication(@PathVariable String lastname){
        ArrayList<String>medicationByPerson = readDataFromService.personListMedication(lastname);
        return medicationByPerson;
    }

}
