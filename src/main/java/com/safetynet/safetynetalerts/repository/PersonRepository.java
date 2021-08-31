package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository

public class PersonRepository extends JsonReadFileRepository {


    public ArrayList<Person> personList () {

        return this.readPersonList();
    }




}

