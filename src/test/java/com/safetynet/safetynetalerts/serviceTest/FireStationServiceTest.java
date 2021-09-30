package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FireStationServiceTest {


    private ArrayList<Person> personList;
    private ArrayList<MedicalRecord>medicalList;
    private ArrayList<FireStation>fireStationList;
    private static FireStationService fireStationService;
    @Mock
    private static FireStationRepository fireStationRepository;
    @Mock
    private static PersonRepository personRepository;
    @Mock
    private static MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    void setup() {
        fireStationService = new FireStationService(fireStationRepository,personRepository,medicalRecordRepository);
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
        fireStationList = new ArrayList<>();
        FireStation fireStation = new FireStation(
                "15 rue dumas",
                "1");
        fireStationList.add(fireStation);

        when(fireStationRepository.getFireStationList()).thenReturn(fireStationList);
        when(personRepository.personList()).thenReturn(personList);
        when(medicalRecordRepository.medicalRecordList()).thenReturn(medicalList);

    }
    @AfterEach
    void clearList() {
        personList.clear();
        medicalList.clear();
        fireStationList.clear();
    }
    @Test
    public void getFireStationListTest() {
        assertEquals(1,fireStationService.getFireStation().size());
    }
    @Test
    public void addFireStationToListTest() {

        FireStation fireStation2 = new FireStation("rue du centre","2");
        fireStationService.addFireStation(fireStation2);
        assertEquals(2,fireStationService.getFireStation().size());
    }
    @Test
    public void deleteFireStationToList() {

        FireStation fireStation3 = new FireStation("rue du centre","2");
        fireStationService.addFireStation(fireStation3);
        assertEquals(2,fireStationService.getFireStation().size());
        fireStationService.deleteFireStation(fireStation3);
        assertEquals(1, fireStationService.getFireStation().size());
    }
    @Test
    public void findFireStationByAddressTest() {
        fireStationService.findFireStation("place de la mairie");
        verify(fireStationRepository,times(1)).getFireStationList();
    }
    @Test
    public void updateFireStationTest() {
        FireStation fireStation4 = new FireStation("place de la mairie","2");
        fireStationService.updateFireStation(fireStation4,"place de la mairie");

        verify(fireStationRepository,times(2)).getFireStationList();
    }
    @Test
    public void getPersonByStation() {
        fireStationService.personsByStation("1");
        verify(fireStationRepository,times(1)).getFireStationList();
        verify(personRepository,times(1)).personList();
        verify(medicalRecordRepository,times(1)).medicalRecordList();
    }
    @Test
    public void getFireStationByPersonAddressTest() {

        assertEquals(1,fireStationService.fireStationByPersonAddress("15 rue dumas").size());
    }
    @Test
    public void getPhoneByFireStationTest() {

        assertEquals(1,fireStationService.phoneByFireStation("1").size());
    }
    @Test
    public void getListOfPersonByStationTest() {

        assertEquals(1,fireStationService.listOfPersonsByStation("1").size());
    }
    @Test
    public void getFirestationWithCount() {

        assertEquals(1,fireStationService.fireStationWithCount("1").size());
    }
}
