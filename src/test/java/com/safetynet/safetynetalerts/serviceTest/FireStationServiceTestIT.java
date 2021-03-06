package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.DTO.*;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FireStationServiceTestIT {

    @Mock
    private FireStationRepository fireStationRepository;
    @Mock
    private FireStation fireStation;

    @Autowired
    private FireStationService fireStationService;



    @Test
    public void getFireStationTest(){
        ArrayList<FireStation> fireStationsList = fireStationService.getFireStation();
        assertEquals(fireStationsList.size(),13);
    }
    @Test
    public void addFireStationTest(){
        fireStation = new FireStation("15 rue du pape", "5");
        ArrayList<FireStation>addFireStationToList = fireStationService.addFireStation(fireStation);
        assertEquals(addFireStationToList.size(),14);
    }
    @Test
    public void deleteFireStationTest(){
        addFireStationTest();
        ArrayList<FireStation> deleteFireStationToList = fireStationService.deleteFireStation(fireStation);
        assertEquals(deleteFireStationToList.size(),13);
    }
    @Test
    public void personByStationTest(){
        ArrayList<FloodStationDTO> personByStationList = fireStationService.personsByStation("4");
        assertEquals(personByStationList.size(),4);
    }
    @Test
    public void fireStationByPersonAddressTest(){
        ArrayList<FireStationByPersonAddressDTO> personsList = fireStationService.fireStationByPersonAddress("1509 Culver St");
        assertEquals(personsList.size(),5);
    }
    @Test
    public void phoneByFireStationTest(){
        ArrayList<PhoneAlertDTO> phoneList = fireStationService.phoneByFireStation("4");
        assertEquals(phoneList.size(),4);
    }
    @Test
    public void listOfPersonByStationTest(){
        ArrayList<FirestationNumberDTO> personsList = fireStationService.listOfPersonsByStation("4");
        assertEquals(personsList.size(),4);
    }
    @Test
    public void fireStationWithCountTest(){
        ArrayList<ListByStationNumberWithCountDTO> personsList = fireStationService.fireStationWithCount("4");
        assertEquals(personsList.size(),1); // Attention ici 1 entr??e mais avec 4 personnes !!
    }
}
