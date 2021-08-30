package com.safetynet.safetynetalerts.repository;
import com.safetynet.safetynetalerts.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository

public abstract class PersonRepository implements CrudRepository<Person, Long> {
    JsonReadFileRepository jsonReadFileRepository = new JsonReadFileRepository();

    public ArrayList<Person> personList () {
        jsonReadFileRepository.readPersonList();
        return personList();
    }


}

