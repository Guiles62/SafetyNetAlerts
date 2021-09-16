package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    public ArrayList<String> fireStationByPersonAddress(String address){
        ArrayList<Person> personsList = personService.getPersons();
        ArrayList<FireStation> fireStationsList = fireStationService.getFireStation();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecord();
        ArrayList<String> listOfPersonsByAddress = new ArrayList<>();

        for (int i=0; i<personsList.size(); i++){
            if (personsList.get(i).getAddress().contains(address)){
                listOfPersonsByAddress.add(personsList.get(i).getFirstname());
                listOfPersonsByAddress.add(personsList.get(i).getLastname());
                listOfPersonsByAddress.add(personsList.get(i).getPhone());
                for (int j=0; j<medicalRecordsList.size(); j++){
                    if(medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())){
                        listOfPersonsByAddress.add(medicalRecordsList.get(j).getBirthdate());
                        listOfPersonsByAddress.add(medicalRecordsList.get(j).getMedications());
                        listOfPersonsByAddress.add(medicalRecordsList.get(j).getAllergies());
                        for (int k=0; k<fireStationsList.size(); k++){
                            if(fireStationsList.get(k).getAddress().contains(personsList.get(i).getAddress())){
                                listOfPersonsByAddress.add(fireStationsList.get(k).getStation());
                            }
                        }
                    }
                }
            }
        }
        return listOfPersonsByAddress;
    }

    public ArrayList<String> phoneByFireStation(String station){

        ArrayList<Person> personsList = personService.getPersons();
        ArrayList<FireStation> fireStationsList = fireStationService.getFireStation();
        ArrayList<String> phoneListByStation = new ArrayList<>();

        for (int i=0; i<fireStationsList.size(); i++){
            if (fireStationsList.get(i).getStation().contains(station)){
                String fireStationAddress = fireStationsList.get(i).getAddress();
                for (int j=0; j<personsList.size(); j++){
                    if( personsList.get(j).getAddress().contains(fireStationAddress)){
                        phoneListByStation.add(personsList.get(j).getPhone());
                            }
                        }
                    }
                }
        return phoneListByStation;
    }
    public ArrayList<String> childList (String address) {
        ArrayList<Person> personsList = personService.getPersons();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordService.getMedicalRecord();
        ArrayList<String> childListByAddress = new ArrayList<>();
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getAddress().contains(address)) {
                for (int j = 0; j < medicalRecordsList.size(); j++) {
                    if (medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())) {
                        String strDate = medicalRecordsList.get(j).getBirthdate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate date = LocalDate.parse(strDate, formatter);
                        LocalDate currentDate = LocalDate.now();
                        if ((ChronoUnit.YEARS.between(date, currentDate)) < 18) {
                            childListByAddress.add(personsList.get(i).getFirstname());
                            childListByAddress.add(personsList.get(i).getLastname());
                            childListByAddress.add(medicalRecordsList.get(j).getBirthdate());
                        }

                    }
                }
            }
        }
        return childListByAddress;
    }
}