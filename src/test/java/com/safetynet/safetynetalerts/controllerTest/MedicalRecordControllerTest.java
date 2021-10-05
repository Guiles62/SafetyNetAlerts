package com.safetynet.safetynetalerts.controllerTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getMedicalRecordTest() throws Exception {
        mockMvc.perform(get("/medicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void addMedicalRecordTest() throws Exception {
        mockMvc.perform(post("/medicalrecord/addmedicalrecord")
                .content(asJsonString(new MedicalRecord("guillaume","morph","06/03/1983","","")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void updateMedicalRecordTest() throws Exception {
        mockMvc.perform(put("/medicalrecord/guillaume")
                .content(asJsonString(new MedicalRecord("guillaume","morph","06/03/1983","","")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void deleteMedicalRecordTest() throws Exception {
        mockMvc.perform(delete("/medicalrecord")).andExpect(status().isOk());
    }
    @Test
    public void getMedicalRecordByNameTest() throws Exception {
        mockMvc.perform(get("/medicalrecord/guillaume")).andExpect(status().isOk());
    }

}
