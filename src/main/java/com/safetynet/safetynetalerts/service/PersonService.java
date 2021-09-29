package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.DTO.AdultsListDTO;
import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.DTO.PersonInfoDTO;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final static Logger logger = LogManager.getLogger("PersonService");

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ArrayList<Person> getPersons() {
        logger.info("safetyGetPersons");
        ArrayList<Person> getPersonList = personRepository.personList();
        return getPersonList;
    }

    public ArrayList<Person> addPerson(Person person) {
        logger.info("safetyAddPerson");
        ArrayList<Person> addPersonList = personRepository.personList();
        addPersonList.add(person);
        return addPersonList;
    }

    public ArrayList<Person> deletePerson(Person person) {
        logger.info("safetyDeletePerson");
        ArrayList<Person> deletePersonOfList = personRepository.personList();
        deletePersonOfList.remove(person);
        return deletePersonOfList;
    }

    public Person findPerson(String name) {
        logger.info("safetyFindPersonByName");
        ArrayList<Person> personName = personRepository.personList();
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
        ArrayList<Person> updateAPerson = personRepository.personList();
        Person uPerson = findPerson(name);
        for (int i = 0; i < updateAPerson.size(); i++) {
            if (updateAPerson.get(i).getFirstname().contains(uPerson.getFirstname())) {
                updateAPerson.set(i, person);
                return updateAPerson.get(i);
            }

        }
        return updatePerson(person,name);
    }

    public ArrayList<String> getMailPersons(String city) {
        logger.info("safetyGetMailPersonsByCity");
        ArrayList<Person> getPersonList = personRepository.personList();
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
        ArrayList<Person> personsList = personRepository.personList();
        ArrayList<MedicalRecord> medicalRecordsList = personRepository.medicalList();
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
        ArrayList<Person> personsList = personRepository.personList();
        ArrayList<MedicalRecord> medicalRecordsList = personRepository.medicalList();
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
        ArrayList<Person> personsList = personRepository.personList();
        ArrayList<MedicalRecord> medicalRecordsList = personRepository.readMedicalRecordsList();
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

