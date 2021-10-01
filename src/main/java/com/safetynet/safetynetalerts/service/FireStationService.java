package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.DTO.*;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


@Service
public class FireStationService {

    private final static Logger logger = LogManager.getLogger("FireStationService");

    @Autowired
    FireStationRepository fireStationRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public FireStationService(FireStationRepository fireStationRepository, PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public ArrayList<FireStation> getFireStation() {
        logger.info("safetyGetFireStation");
        ArrayList<FireStation> getFireStationList = fireStationRepository.getFireStationList();
        return getFireStationList;
    }

    public ArrayList<FireStation> addFireStation(FireStation fireStation) {
        logger.info("safetyAddFireStation");
        ArrayList<FireStation> addFireStationList = fireStationRepository.addFireStation(fireStation);
        return addFireStationList;
    }

    public ArrayList<FireStation> deleteFireStation(FireStation fireStation) {
        logger.info("safetyDeleteFireStation");
        ArrayList<FireStation> deleteFireStationList = fireStationRepository.deleteFireStation(fireStation);
        return deleteFireStationList;
    }

    public FireStation findFireStation(String address) {
        logger.info("safetyFindFireStation");
        FireStation fireStationName = fireStationRepository.findFireStation(address);
        return fireStationName;
    }

    public FireStation updateFireStation(FireStation fireStation, String address) {
        logger.info("safetyUpdateFireStation");
        FireStation updateFireStation = fireStationRepository.updateFireStation(fireStation, address);
        return updateFireStation;
    }

    public ArrayList<FloodStationDTO> personsByStation(String station) {
        logger.info("safetyPersonListByStation");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.getFireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
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
        logger.info("safetyFireStationByPersonAddress");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.getFireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
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
        logger.info("safetyPhoneListByStation");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.getFireStationList();
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
        logger.info("safetyListOfPersonsByStation");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<FireStation> fireStationsList = fireStationRepository.getFireStationList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
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
        logger.info("safetyListOfPersonsByStationWithAdultAndChildrenCount");
        ArrayList<FirestationNumberDTO> listOfPerson = listOfPersonsByStation(station);
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
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