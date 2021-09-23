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


    public ArrayList<Person> personList () {
        logger.info("safetyGetPersonsList");

        return this.readPersonList();
    }
    public ArrayList<MedicalRecord> medicalList(){
        logger.info("safetyGetMedicalList");

        return this.readMedicalRecordsList();
    }
    public ArrayList<FireStation> fireStationList(){
        logger.info("safetyGetFireStationList");

        return this.readFireStationList();
    }

}

