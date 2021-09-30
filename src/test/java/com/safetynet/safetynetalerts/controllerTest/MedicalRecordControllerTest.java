package com.safetynet.safetynetalerts.controllerTest;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.safetynet.safetynetalerts.controller.MedicalRecordController;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MedicalRecordController.class)
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private static MedicalRecordService medicalRecordService;
    @Mock
    private static MedicalRecordRepository medicalRecordRepository;

    @Test
    public void getMedicalRecordTest() throws Exception {
        mockMvc.perform(get("/medicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void addMedicalRecordTest() throws Exception {
        MedicalRecord medicalRecord = new MedicalRecord("guillaume","morph","06/03/1983","","");
        ArrayList<MedicalRecord>addMedicalRecordList = new ArrayList<>();
        addMedicalRecordList.add(medicalRecord);
        when(medicalRecordService.addMedicalRecord(medicalRecord)).thenReturn(addMedicalRecordList);
        mockMvc.perform(post("/medicalrecord/addmedicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void updateMedicalRecordTest() throws Exception {
        MedicalRecord medicalRecord2 = new MedicalRecord("guillaume","morph","06/03/1983","","");
        when(medicalRecordService.updateMedicalRecord(medicalRecord2,"guillaume")).thenReturn(medicalRecord2);
        mockMvc.perform(put("/medicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void deleteMedicalRecordTest() throws Exception {
        mockMvc.perform(delete("/medicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void getMedicalRecordByNameTest() throws Exception {
        MedicalRecord medicalRecord3 = new MedicalRecord("guillaume","morph","06/03/1983","","");
        when(medicalRecordService.findMedicalRecords("guillaume")).thenReturn(medicalRecord3);
        mockMvc.perform(get("/medicalrecord?name=guillaume")).andExpect(status().isOk());
    }

}
