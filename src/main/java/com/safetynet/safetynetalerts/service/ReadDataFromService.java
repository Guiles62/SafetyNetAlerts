package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.FireStation;
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
        ArrayList<Person> personsList = personService.getPersons();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecord();
        ArrayList<String> medicationOfPersons = new ArrayList<>();

        for (int i =0; i<personsList.size(); i++) {

                if (personsList.get(i).getLastname().contains(lastname)) {
                    medicationOfPersons.add(personsList.get(i).getFirstname());
                    medicationOfPersons.add(personsList.get(i).getLastname());
                    medicationOfPersons.add(personsList.get(i).getAddress());
                    medicationOfPersons.add(personsList.get(i).getCity());
                    medicationOfPersons.add(personsList.get(i).getZip());
                    medicationOfPersons.add(personsList.get(i).getEmail());
                    for (int j = 0; j<medicalRecordsList.size();j++){
                        if(medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())){
                            medicationOfPersons.add(medicalRecordsList.get(j).getBirthdate());
                            medicationOfPersons.add(medicalRecordsList.get(j).getMedications());
                            medicationOfPersons.add(medicalRecordsList.get(j).getAllergies());
                        }
                    }
                }
        }
        return medicationOfPersons;
    }

    public ArrayList<String> personsByStation(String station){
        ArrayList<Person> personsList = personService.getPersons();
        ArrayList<FireStation> fireStationsList = fireStationService.getFireStation();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecord();
        ArrayList<String> personsListByStation = new ArrayList<>();

        for (int i=0; i<fireStationsList.size(); i++){
            if (fireStationsList.get(i).getStation().contains(station)){
               String fireStationAddress = fireStationsList.get(i).getAddress();
                for (int j=0; j<personsList.size(); j++){
                    if( personsList.get(j).getAddress().contains(fireStationAddress)){
                        personsListByStation.add(personsList.get(j).getFirstname());
                        personsListByStation.add(personsList.get(j).getLastname());
                        personsListByStation.add(personsList.get(j).getAddress());
                        personsListByStation.add(personsList.get(j).getPhone());
                        for(int k=0; k<medicalRecordsList.size(); k++){
                            if(medicalRecordsList.get(k).getFirstname().contains(personsList.get(j).getFirstname())){
                                personsListByStation.add(medicalRecordsList.get(k).getBirthdate());
                                personsListByStation.add(medicalRecordsList.get(k).getMedications());
                                personsListByStation.add(medicalRecordsList.get(k).getAllergies());
                            }
                        }
                    }
                }
            }
        }
        return personsListByStation;

    }


}