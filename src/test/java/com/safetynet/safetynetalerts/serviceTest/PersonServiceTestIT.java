package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.DTO.PersonInfoDTO;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class PersonServiceTestIT {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private Person person;

    @Autowired
    private PersonService personService;




    @Test
    public void getPersonsTest(){
        ArrayList<Person> personList = personService.getPersons();
            assertEquals(personList.size(), 23);
    }

    @Test
    public void addPersonTest(){
        person = new Person("tonton","tutu","00 tt 00","Paris","99999","00000000","mmm@nnn");
        ArrayList<Person> addPersonList = personService.addPerson(person);
            assertEquals(addPersonList.size(), 24);
   }

   @Test
    public void deletePersonTest(){
       addPersonTest();
       ArrayList<Person> personList = personService.deletePerson(person);
            assertEquals(personList.size(), 23);
   }
   @Test
    public void getMailsPersonTest(){
        ArrayList<String> mailsPerson = personService.getMailPersons("Culver");
            assertEquals(mailsPerson.size(), 23);
   }
   @Test
    public void personListMedicationTest(){
        ArrayList<PersonInfoDTO> listMedication = personService.personListMedication("John","Boyd");
            assertEquals(listMedication.size(), 6);
   }
   @Test
    public void listOfChildrenByAddressTest(){
        ArrayList<ChildrenListDTO> childrenList = personService.childrenList("1509 Culver St");
            assertEquals(childrenList.size(),2);
   }

}
