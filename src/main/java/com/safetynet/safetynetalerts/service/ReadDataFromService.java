package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReadDataFromService {
    @Autowired
    FireStationService fireStationService;
    @Autowired
    PersonService personService;
    @Autowired
    MedicalRecordService medicalRecordService;


    public ArrayList<String> personListMedication(String lastname){
        ArrayList<Person> personList = personService.getPersons();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecord();
        ArrayList<String> medicationOfPersons = new ArrayList<>();
        for (int i =0; i<personList.size(); i++) {

                if (personList.get(i).getLastname().contains(lastname)) {
                    medicationOfPersons.add(personList.get(i).getFirstname());
                    medicationOfPersons.add(personList.get(i).getLastname());
                    medicationOfPersons.add(personList.get(i).getAddress());
                    medicationOfPersons.add(personList.get(i).getCity());
                    medicationOfPersons.add(personList.get(i).getZip());
                    for (int j = 0; j<medicalRecordsList.size();j++){
                        if(medicalRecordsList.get(j).getFirstname().contains(personList.get(i).getFirstname())){
                            medicationOfPersons.add(medicalRecordsList.get(j).getBirthdate());
                            medicationOfPersons.add(medicalRecordsList.get(j).getMedications());
                            medicationOfPersons.add(medicalRecordsList.get(j).getAllergies());
                        }
                    }
                }
        }
        return medicationOfPersons;
    }

}