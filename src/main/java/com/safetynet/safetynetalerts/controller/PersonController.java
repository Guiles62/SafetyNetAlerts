package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.DTO.PersonInfoDTO;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    // donne les infos sur la médication de personnes
    @GetMapping(value = "personInfo/{lastname}")
    public ArrayList<PersonInfoDTO>personListMedication(@PathVariable String lastname){
        ArrayList<PersonInfoDTO>medicationByPerson = personService.personListMedication(lastname);
        return medicationByPerson;
    }

    // donne la liste des enfants de moins de 18 ans a une adresse donnée ainsi que les personnes qui y habitent
    @GetMapping ( value = "childAlert/{address}")
    public ArrayList<ChildrenListDTO> listOfChildByAddress(@PathVariable String address){
        ArrayList<ChildrenListDTO> listOfChild = personService.childrenList(address);
        return listOfChild;
    }

}
