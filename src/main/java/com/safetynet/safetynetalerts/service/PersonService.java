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

    public ArrayList<Person> getPerson() {
        ArrayList<Person> getPersonList = personRepository.personList();
        return getPersonList;
    }



}
