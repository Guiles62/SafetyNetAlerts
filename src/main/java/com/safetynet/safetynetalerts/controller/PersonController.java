package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.DTO.PersonInfoDTO;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@RestController
public class PersonController {

    private final static Logger logger = LogManager.getLogger("PersonController");

    @Autowired
    PersonService personService;



    @GetMapping(value ="person")
    public ArrayList<Person> getPersons(){
        logger.info("safetyGetPersons");
        ArrayList<Person> getPersonList = personService.getPersons();
        return getPersonList;
    }
    @GetMapping(value ="person/{name}")
    public Person getPerson(@PathVariable String name){
        logger.info("safetyGetPersonByName");
        Person person = personService.findPerson(name);
        return person;
    }
    @PostMapping(value ="person/addperson" )
    public ArrayList<Person> addPerson(@RequestBody Person person){
        logger.info("safetyAddPerson");
        ArrayList<Person> addPersonList = personService.addPerson(person);
        return addPersonList;
    }
    @PutMapping(value="person/{name}")
    public Person updatePerson(@RequestBody Person person,@PathVariable String name){
        logger.info("safetyUpdatePerson");
        Person uPerson = personService.updatePerson(person,name);
        return uPerson;
    }

    @DeleteMapping(value ="person")
    public ArrayList<Person> deletePerson(Person person){
        logger.info("safetyDeletePerson");
        ArrayList<Person> deletePersonList = personService.deletePerson(person);
        return deletePersonList;
    }
    // donne la liste des mails des habitants de la ville
    @GetMapping(value = "communityEmail/{city}")
    public ArrayList<String> personsMail(@PathVariable String city){
        logger.info("safetyPersonMailByCity");
        ArrayList<String> mailOfPersons = personService.getMailPersons(city);
        return mailOfPersons;
    }
    // donne les infos sur la médication de personnes
    @GetMapping(value = "personInfo/{lastname}")
    public ArrayList<PersonInfoDTO>personListMedication(@PathVariable String lastname){
        logger.info("safetyPersonListMedicationBYName");
        ArrayList<PersonInfoDTO>medicationByPerson = personService.personListMedication(lastname);
        return medicationByPerson;
    }

    // donne la liste des enfants de moins de 18 ans a une adresse donnée ainsi que les personnes qui y habitent
    @GetMapping ( value = "childAlert/{address}")
    public ArrayList<ChildrenListDTO> listOfChildrenByAddress(@PathVariable String address){
        logger.info("safetyListOfChildrenByAddress");
        ArrayList<ChildrenListDTO> listOfChildren = personService.childrenList(address);
        return listOfChildren;
    }

}
