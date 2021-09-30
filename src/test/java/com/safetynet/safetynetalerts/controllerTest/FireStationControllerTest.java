package com.safetynet.safetynetalerts.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.safetynet.safetynetalerts.DTO.FireStationByPersonAddressDTO;
import com.safetynet.safetynetalerts.DTO.FloodStationDTO;
import com.safetynet.safetynetalerts.DTO.ListByStationNumberWithCountDTO;
import com.safetynet.safetynetalerts.DTO.PhoneAlertDTO;
import com.safetynet.safetynetalerts.controller.FireStationController;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FireStationController.class)
public class FireStationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private static FireStationService fireStationService;
    @Mock
    private static FireStationController fireStationController;

    @Test
    public void getFireStationTest() throws Exception {
        mockMvc.perform(get("/firestation")).andExpect(status().isOk());
    }
    @Test
    public void findStationByAddressTest() throws Exception {
        FireStation fireStation = new FireStation("aaaa","1");
        when(fireStationService.findFireStation("aaaa")).thenReturn(fireStation);
        mockMvc.perform(get("/firestation?address=aaaa")).andExpect(status().isOk());
    }
    @Test
    public void addFireStationTest() throws Exception {
        ArrayList<FireStation> addFireStation = new ArrayList<>();
        FireStation fireStation2 = new FireStation("aaaa","1");
        addFireStation.add(fireStation2);
        when(fireStationService.addFireStation(fireStation2)).thenReturn(addFireStation);
        mockMvc.perform(get("/firestation/addfirestation")).andExpect(status().isOk());
    }
    @Test
    public void deleteFireStationTest() throws Exception {
        mockMvc.perform(delete("/firestation")).andExpect(status().isOk());
    }
    @Test
    public void updateFireStationTest() throws Exception {
        FireStation fireStation = new FireStation("aaaa","1");
        when(fireStationService.updateFireStation(fireStation,"aaaa")).thenReturn(fireStation);
        mockMvc.perform(get("/firestation/aaaa")).andExpect(status().isOk());
    }
    @Test
    public void getPersonByStationTest() throws Exception {
        ArrayList<FloodStationDTO> getPersonListByStation = new ArrayList<>();
        when(fireStationService.personsByStation("1")).thenReturn(getPersonListByStation);
        mockMvc.perform(get("/flood?station=1")).andExpect(status().isOk());
    }
    @Test
    public void getPhoneListByStationTest() throws Exception {
        ArrayList<PhoneAlertDTO> getPhoneListByStation = new ArrayList<>();
        when(fireStationService.phoneByFireStation("1")).thenReturn(getPhoneListByStation);
        mockMvc.perform(get("/phoneAlert?station=1")).andExpect(status().isOk());
    }
    @Test
    public void getPersonListByFireStationTest() throws Exception {
        ArrayList<FireStationByPersonAddressDTO> getPersonList = new ArrayList<>();
        when(fireStationService.fireStationByPersonAddress("aaaa")).thenReturn(getPersonList);
        mockMvc.perform(get("/fire?address=aaaa")).andExpect(status().isOk());
    }
    @Test
    public void getPersonListByStationTest() throws Exception {
        ArrayList<ListByStationNumberWithCountDTO> personListByStation = new ArrayList<>();
        when(fireStationService.fireStationWithCount("1")).thenReturn(personListByStation);
        mockMvc.perform(get("/fireStation?station=1")).andExpect(status().isOk());

    }
}
