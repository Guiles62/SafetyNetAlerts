package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.DTO.AdultsListDTO;
import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.DTO.PersonInfoDTO;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;



@Service
public class PersonService {



    private PersonRepository personRepository;
    private MedicalRecordRepository medicalRecordRepository;

    private final static Logger logger = LogManager.getLogger("PersonService");

    public PersonService(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository) {
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public ArrayList<Person> getPersons() {
        logger.info("safetyGetPersons");
        ArrayList<Person> getPersonList = personRepository.getPersonList();
        return getPersonList;
    }

    public ArrayList<Person> addPerson(Person person) {
        logger.info("safetyAddPerson");
        ArrayList<Person> addPersonList = personRepository.addPerson(person);
        return addPersonList;
    }

    public ArrayList<Person> deletePerson(Person person) {
        logger.info("safetyDeletePerson");
        ArrayList<Person> deletePersonOfList = personRepository.deletePerson(person);
        return deletePersonOfList;
    }

    public Person findPerson(String name) {
        logger.info("safetyFindPersonByName");
        Person personName = personRepository.findPerson(name);
        return personName;
    }

    public Person updatePerson(Person person,String name) {
        logger.info("safetyUpdatePerson");
        Person updateAPerson = personRepository.updatePerson(person, name);
        return updateAPerson;
    }

    public ArrayList<String> getMailPersons(String city) {
        logger.info("safetyGetMailPersonsByCity");
        ArrayList<Person> getPersonList = personRepository.getPersonList();
        ArrayList<String> getPersonsMail = new ArrayList<>();
        for(int i = 0; i< getPersonList.size(); i++){
            if (getPersonList.get(i).getCity().contains(city)) {
                getPersonsMail.add(getPersonList.get(i).getFirstname() + getPersonList.get(i).getLastname() + getPersonList.get(i).getEmail());

            }
        }
        return getPersonsMail;
    }

    public ArrayList<PersonInfoDTO> personListMedication(String lastname){
        logger.info("safetyPersonListMedicationByName");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
        ArrayList<PersonInfoDTO> medicationOfPersons = new ArrayList<>();

        for (int i =0; i<personsList.size(); i++) {
            if (personsList.get(i).getLastname().contains(lastname)){
                for (int j = 0; j<medicalRecordsList.size();j++){
                    if(medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())){
                        medicationOfPersons.add(new PersonInfoDTO(
                        personsList.get(i).getFirstname(),
                        personsList.get(i).getLastname(),
                        personsList.get(i).getAddress(),
                        personsList.get(i).getCity(),
                        personsList.get(i).getZip(),
                        personsList.get(i).getEmail(),
                        medicalRecordsList.get(j).getBirthdate(),
                        medicalRecordsList.get(j).getMedications(),
                        medicalRecordsList.get(j).getAllergies()));
                    }
                }
            }
        }
        return medicationOfPersons;
    }


    public ArrayList<AdultsListDTO> adultList (String address) {
        logger.info("safetyAdultList");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
        ArrayList<AdultsListDTO> adultsListByAddress = new ArrayList<>();
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getAddress().contains(address)) {
                for (int j = 0; j < medicalRecordsList.size(); j++) {
                    if (medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())) {
                        String strDate = medicalRecordsList.get(j).getBirthdate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate date = LocalDate.parse(strDate, formatter);
                        LocalDate currentDate = LocalDate.now();
                        if ((ChronoUnit.YEARS.between(date, currentDate)) > 18) {
                            adultsListByAddress.add(new AdultsListDTO(
                                    personsList.get(i).getFirstname(),
                                    personsList.get(i).getLastname()));


                        }
                    }
                }
            }
        }
        return adultsListByAddress;

    }


    public ArrayList<ChildrenListDTO> childrenList (String address) {
        logger.info("safetyChildrenList");
        ArrayList<Person> personsList = personRepository.getPersonList();
        ArrayList<MedicalRecord> medicalRecordsList = medicalRecordRepository.getMedicalRecordList();
        ArrayList<AdultsListDTO> adultsList = adultList(address);
        ArrayList<ChildrenListDTO> childListByAddress = new ArrayList<>();
        for (int i = 0; i < personsList.size(); i++) {
            if (personsList.get(i).getAddress().contains(address)) {
                for (int j = 0; j < medicalRecordsList.size(); j++) {
                    if (medicalRecordsList.get(j).getFirstname().contains(personsList.get(i).getFirstname())) {
                        String strDate = medicalRecordsList.get(j).getBirthdate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate date = LocalDate.parse(strDate, formatter);
                        LocalDate currentDate = LocalDate.now();
                        if ((ChronoUnit.YEARS.between(date, currentDate)) < 18) {
                            childListByAddress.add(new ChildrenListDTO(
                                    personsList.get(i).getFirstname(),
                                    personsList.get(i).getLastname(),
                                    medicalRecordsList.get(j).getBirthdate(),
                                    adultsList));

                        }
                        }
                    }
                }
            }
            return childListByAddress;

        }

    }

