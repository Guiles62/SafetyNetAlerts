package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.DTO.*;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


@Service
public class FireStationService {

    @Autowired
    FireStationRepository fireStationRepository;

    public ArrayList<FireStation> getFireStation() {
        ArrayList<FireStation> getFireStationList = fireStationRepository.fireStationList();
        return getFireStationList;
    }

    public ArrayList<FireStation> addFireStation(FireStation fireStation) {
        ArrayList<FireStation> addFireStationList = fireStationRepository.fireStationList();
        addFireStationList.add(fireStation);
        return addFireStationList;
    }

    public ArrayList<FireStation> deleteFireStation(FireStation fireStation) {
        ArrayList<FireStation> deleteFireStationList = fireStationRepository.fireStationList();
        deleteFireStationList.remove(fireStation);
        return deleteFireStationList;
    }

    public FireStation findFireStation(String address) {
        ArrayList<FireStation> fireStationName = fireStationRepository.fireStationList();
        for (int i = 0; i < fireStationName.size(); i++) {
            if (fireStationName.get(i).getAddress().toLowerCase().contains(address)) {
                FireStation fireStationFind = fireStationName.get(i);
                return fireStationFind;
            }
        }
        return findFireStation(address);
    }

    public FireStation updateFireStation(FireStation fireStation, String address) {
        ArrayList<FireStation> updateFireStation = fireStationRepository.fireStationList();
        FireStation uFireStation = findFireStation(address);
        for (int i = 0; i < updateFireStation.size(); i++) {
            if (updateFireStation.get(i).getAddress().contains(uFireStation.getAddress())) {
                updateFireStation.set(i, fireStation);
                return updateFireStation.get(i);
            }

        }
        return updateFireStation(fireStation, address);
    }

    public ArrayList<FloodStationDTO> personsByStation(String station) {
        ArrayList<Person> personsList = fireStationRepository.personList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.fireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = fireStationRepository.medicalRecordsList();
        ArrayList<FloodStationDTO> personsListByStation = new ArrayList<>();

        for (int i = 0; i < fireStationsList.size(); i++) {
            if (fireStationsList.get(i).getStation().contains(station)) {
                String fireStationAddress = fireStationsList.get(i).getAddress();
                for (int j = 0; j < personsList.size(); j++) {
                    if (personsList.get(j).getAddress().contains(fireStationAddress)) {
                        for (int k = 0; k < medicalRecordsList.size(); k++) {
                            if (medicalRecordsList.get(k).getFirstname().contains(personsList.get(j).getFirstname())) {
                                personsListByStation.add(new FloodStationDTO(
                                        personsList.get(j).getFirstname(),
                                        personsList.get(j).getLastname(),
                                        personsList.get(j).getAddress(),
                                        personsList.get(j).getPhone(),
                                        medicalRecordsList.get(k).getBirthdate(),
                                        medicalRecordsList.get(k).getMedications(),
                                        medicalRecordsList.get(k).getAllergies()));
                            }
                        }
                    }
                }
            }
        }
        return personsListByStation;
    }

    public ArrayList<FireStationByPersonAddressDTO> fireStationByPersonAddress(String address) {
        ArrayList<Person> personsList = fireStationRepository.personList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.fireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = fireStationRepository.medicalRecordsList();
        ArrayList<FireStationByPersonAddressDTO> listOfPersonsByAddress = new ArrayList<>();

        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getAddress().contains(address)) {

                for (int j = 0; j < medicalRecordsList.size(); j++) {
                    if (medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())) {

                        for (int k = 0; k < fireStationsList.size(); k++) {
                            if (fireStationsList.get(k).getAddress().contains(personsList.get(i).getAddress())) {
                                listOfPersonsByAddress.add(new FireStationByPersonAddressDTO(
                                        personsList.get(i).getFirstname(),
                                        personsList.get(i).getLastname(),
                                        personsList.get(i).getPhone(),
                                        medicalRecordsList.get(j).getBirthdate(),
                                        medicalRecordsList.get(j).getMedications(),
                                        medicalRecordsList.get(j).getAllergies(),
                                        fireStationsList.get(k).getStation()));
                            }
                        }
                    }
                }
            }
        }
        return listOfPersonsByAddress;
    }

    public ArrayList<PhoneAlertDTO> phoneByFireStation(String station) {

        ArrayList<Person> personsList = fireStationRepository.personList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.fireStationList();
        ArrayList<PhoneAlertDTO> phoneListByStation = new ArrayList<>();

        for (int i = 0; i < fireStationsList.size(); i++) {
            if (fireStationsList.get(i).getStation().contains(station)) {
                String fireStationAddress = fireStationsList.get(i).getAddress();
                for (int j = 0; j < personsList.size(); j++) {
                    if (personsList.get(j).getAddress().contains(fireStationAddress)) {
                        phoneListByStation.add(new PhoneAlertDTO(personsList.get(j).getPhone()));
                    }
                }
            }
        }
        return phoneListByStation;
    }

    public ArrayList<FirestationNumberDTO> listOfPersonsByStation(String station) {
        ArrayList<Person> personsList = fireStationRepository.personList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.fireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = fireStationRepository.medicalRecordsList();
        ArrayList<FirestationNumberDTO> listOfPersonsByStationNumber = new ArrayList<>();
        for (int i = 0; i < fireStationsList.size(); i++) {
            if (fireStationsList.get(i).getStation().contains(station)) {
                String fireStationAddress = fireStationsList.get(i).getAddress();
                for (int j = 0; j < personsList.size(); j++) {
                    if (personsList.get(j).getAddress().contains(fireStationAddress)) {
                        for (int k = 0; k < medicalRecordsList.size(); k++) {

                        }
                        listOfPersonsByStationNumber.add(new FirestationNumberDTO(
                                personsList.get(j).getFirstname(),
                                personsList.get(j).getLastname(),
                                personsList.get(j).getAddress(),
                                personsList.get(j).getCity(),
                                personsList.get(j).getZip(),
                                personsList.get(j).getPhone()));

                    }
                }
            }
        }
        return listOfPersonsByStationNumber;
    }

    public ArrayList<ListByStationNumberWithCountDTO> fireStationWithCount(String station) {
        ArrayList<FirestationNumberDTO> listOfPerson = listOfPersonsByStation(station);
        ArrayList<MedicalRecord> medicalRecordsList = fireStationRepository.readMedicalRecordsList();
        ArrayList<ListByStationNumberWithCountDTO> listOfPersonByStationWithCount = new ArrayList<>();
        ArrayList<String> adultCount = new ArrayList<>();
        ArrayList<String> childrenCount = new ArrayList<>();
        for (int i = 0; i < listOfPerson.size(); i++) {
            for (int j = 0; j < medicalRecordsList.size(); j++) {
                if (medicalRecordsList.get(j).getFirstname().contains(listOfPerson.get(i).getFirstname())) {
                    String strDate = medicalRecordsList.get(j).getBirthdate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate date = LocalDate.parse(strDate, formatter);
                    LocalDate currentDate = LocalDate.now();
                    if ((ChronoUnit.YEARS.between(date, currentDate)) < 18) {
                        childrenCount.add(medicalRecordsList.get(j).getFirstname());
                    } else {
                        adultCount.add(medicalRecordsList.get(j).getFirstname());
                    }
                }

            }

        }
        listOfPersonByStationWithCount.add(new ListByStationNumberWithCountDTO(listOfPerson, adultCount.size(), childrenCount.size()));
        return listOfPersonByStationWithCount;
    }
}