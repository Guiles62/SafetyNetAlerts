package com.safetynet.safetynetalerts.PersonControllerTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.safetynet.safetynetalerts.controller.PersonController;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void getPersonTest() throws Exception {
        mockMvc.perform(get("/person")).andExpect(status().isOk());
    }
    @Test
    public void getPersonByNameTest() throws Exception {
        mockMvc.perform(get("/person/John")).andExpect(status().isOk());
    }
    @Test
    public void addPersonTest() throws Exception {
        Person person = new Person(
                "tonton",
                "tata",
                "rue du 8 mai",
                "Lile",
                "59000",
                "0600000000",
                "tonton@gmail.com");

        mockMvc.perform(post("/person/addperson")).andExpect(status().isOk());
    }
    @Test
    public void updatePersonTest() throws Exception {
        mockMvc.perform(put("/person/John")).andExpect(status().isOk());
    }
    @Test
    public void deletePersonTest() throws Exception {
        mockMvc.perform(delete("/person")).andExpect(status().isOk());
    }
    @Test
    public void personsMailTest() throws Exception {
        mockMvc.perform(get("/communityEmail/Culver")).andExpect(status().isOk());
    }
    @Test
    public void personListMedicationTest() throws Exception {
        mockMvc.perform(get("/personInfo/Boyd")).andExpect(status().isOk());
    }
    @Test
    public void childrenByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert/1509 Culver St")).andExpect(status().isOk());
    }
}
