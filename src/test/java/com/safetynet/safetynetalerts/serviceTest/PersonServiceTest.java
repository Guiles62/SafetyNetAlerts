package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
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

    @BeforeEach
    void setup() {
        personService = new PersonService(personRepository);
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

        when(personRepository.personList()).thenReturn(personList);

        assertEquals(1, personService.getPersons().size());

        verify(personRepository,times(1)).personList();
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
        when(personRepository.personList()).thenReturn(personList);
        personService.addPerson(person2);
        assertEquals(2,personService.getPersons().size());

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
        when(personRepository.personList()).thenReturn(personList);
        personService.addPerson(person3);
        assertEquals(2,personService.getPersons().size());
        personService.deletePerson(person3);
        assertEquals(1,personService.getPersons().size());
    }
    @Test
    public void findPersonTest() {
        when(personRepository.personList()).thenReturn(personList);
        personService.findPerson("guillaume");
        verify(personRepository,times(1)).personList();
    }
    @Test
    public void updatePersonTest() {
        when(personRepository.personList()).thenReturn(personList);
        Person person4 = new Person(
                "guillaume",
                "morph",
                "15 rue dumas",
                "lomme",
                "59160",
                "0700000000",
                "guilesmorph@gmail.com");
        personService.updatePerson(person4, "guillaume");
        verify(personRepository,times(2)).personList();
    }
    @Test
    public void getMailsByCityTest() {
        when(personRepository.personList()).thenReturn(personList);

        assertEquals("[guillaumemorphguilesmorph@gmail.com]",personService.getMailPersons("lomme").toString());
    }
    @Test
    public void getPersonListMedicationTest() {
        when(personRepository.personList()).thenReturn(personList);
        when(personRepository.medicalList()).thenReturn(medicalList);

        assertEquals(1,personService.personListMedication("morph").size());
    }
    @Test
    public void getAdultListTest() {
        when(personRepository.personList()).thenReturn(personList);
        when(personRepository.medicalList()).thenReturn(medicalList);

        assertEquals(1,personService.adultList("15 rue dumas").size());
    }
    @Test
    public void getChildrenListTest() {
        when(personRepository.personList()).thenReturn(personList);
        when(personRepository.medicalList()).thenReturn(medicalList);

        assertEquals(0,personService.childrenList("15 rue dumas").size());
    }
}
