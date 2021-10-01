package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


@Repository

public class PersonRepository extends JsonReadFileRepository {

    private final static Logger logger = LogManager.getLogger("PersonRepository");


    public ArrayList<Person> getPersonList () {
        logger.info("safetyGetPersonsList");
        return this.readPersonList();
    }
    public ArrayList<Person> addPerson(Person person) {
        logger.info("safetyAddPerson");
        ArrayList<Person> addPersonList = getPersonList();
        addPersonList.add(person);
        return addPersonList;
    }

    public ArrayList<Person> deletePerson(Person person) {
        logger.info("safetyDeletePerson");
        ArrayList<Person> deletePersonOfList = getPersonList();
        deletePersonOfList.remove(person);
        return deletePersonOfList;
    }

    public Person findPerson(String name) {
        logger.info("safetyFindPersonByName");
        ArrayList<Person> personName = getPersonList();
        for (int i = 0; i < personName.size(); i++) {
            if (personName.get(i).getFirstname().toLowerCase().contains(name)) {
                Person personFind = personName.get(i);
                return personFind;
            }
        }
        return findPerson(name);
    }

    public Person updatePerson(Person person,String name) {
        logger.info("safetyUpdatePerson");
        ArrayList<Person> updateAPerson = getPersonList();
        for (int i = 0; i < updateAPerson.size(); i++) {
            if (updateAPerson.get(i).getFirstname().contains(name)) {
                updateAPerson.set(i, person);
            }
            return updateAPerson.get(i);
        }
        return updatePerson(person,name);
    }

}

