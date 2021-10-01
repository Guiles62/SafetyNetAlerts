package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonServiceTest {

    private ArrayList<Person>personList;
    private ArrayList<MedicalRecord>medicalList;
    private static PersonService personService;
    @Mock
    private static PersonRepository personRepository;
    @Mock
    private static MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    void setup() {
        personService = new PersonService(personRepository, medicalRecordRepository);
        personList = new ArrayList<>();
        Person person = new Person(
                "guillaume",
                "morph",
                "15 rue dumas",
                "lomme",
                "59160",
                "0700000000",
                "guilesmorph@gmail.com");
        personList.add(person);
        medicalList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord(
                "guillaume",
                "morph",
                "06/03/1983",
                "",
                "");
        medicalList.add(medicalRecord);

    }
    @AfterEach
    void clearList() {
        personList.clear();
        medicalList.clear();
    }

    @Test
    public void getPersonTest() {

        when(personRepository.getPersonList()).thenReturn(personList);

        assertEquals(1, personService.getPersons().size());

        verify(personRepository,times(1)).getPersonList();
    }
    @Test
    public void addPersonToListTest() {
        Person person2 = new Person(
                "tonton",
                "tata",
                "15 rue colonel dumont",
                "grenoble",
                "38000",
                "0782427444",
                "gbouzazi@gmail.com");
        when(personRepository.addPerson(person2)).thenReturn(personList);
        personService.addPerson(person2);
        verify(personRepository,times(1)).addPerson(person2);

    }
    @Test
    public void deletePersonToListTest() {
        Person person3 = new Person(
                "tonton",
                "tata",
                "15 rue colonel dumont",
                "grenoble",
                "38000",
                "0782427444",
                "gbouzazi@gmail.com");
        when(personRepository.addPerson(person3)).thenReturn(personList);
        personService.addPerson(person3);
        verify(personRepository,times(1)).addPerson(person3);
        when(personRepository.deletePerson(person3)).thenReturn(personList);
        personService.deletePerson(person3);
        verify(personRepository,times(1)).deletePerson(person3);

    }
    @Test
    public void findPersonTest() {
        Person person4 = new Person(
                "tonton",
                "tata",
                "15 rue colonel dumont",
                "grenoble",
                "38000",
                "0782427444",
                "gbouzazi@gmail.com");
        when(personRepository.findPerson("tonton")).thenReturn(person4);
        personService.findPerson("tonton");
        verify(personRepository,times(1)).findPerson("tonton");
    }
    @Test
    public void updatePersonTest() {
        Person person5 = new Person(
                "guillaume",
                "morph",
                "15 rue dumas",
                "lomme",
                "59160",
                "0700000000",
                "guilesmorph@gmail.com");
        when(personRepository.updatePerson(person5,"guillaume")).thenReturn(person5);
        personService.updatePerson(person5, "guillaume");
        verify(personRepository,times(1)).updatePerson(person5,"guillaume");
    }
    @Test
    public void getMailsByCityTest() {
        when(personRepository.getPersonList()).thenReturn(personList);

        assertEquals("[guillaumemorphguilesmorph@gmail.com]",personService.getMailPersons("lomme").toString());
    }
    @Test
    public void getPersonListMedicationTest() {
        when(personRepository.getPersonList()).thenReturn(personList);
        when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalList);

        assertEquals(1,personService.personListMedication("morph").size());
    }
    @Test
    public void getAdultListTest() {
        when(personRepository.getPersonList()).thenReturn(personList);
        when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalList);

        assertEquals(1,personService.adultList("15 rue dumas").size());
    }
    @Test
    public void getChildrenListTest() {
        when(personRepository.getPersonList()).thenReturn(personList);
        when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalList);

        assertEquals(0,personService.childrenList("15 rue dumas").size());
    }
}
