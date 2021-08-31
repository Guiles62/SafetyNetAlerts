package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping(value ="person")
    public ArrayList<Person> getPerson(){
        ArrayList<Person> getPersonList = personService.getPerson();
        return getPersonList;
    }



}
