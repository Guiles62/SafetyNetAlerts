package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class FireStationRepository extends JsonReadFileRepository {

    public ArrayList<FireStation> fireStationList(){

        return this.readFireStationList();
    }
    public ArrayList<Person> personList(){

        return this.readPersonList();
    }
    public ArrayList<MedicalRecord> medicalRecordsList(){

        return this.readMedicalRecordsList();
    }

}
