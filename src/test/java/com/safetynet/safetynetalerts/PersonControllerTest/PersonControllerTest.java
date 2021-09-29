package com.safetynet.safetynetalerts.PersonControllerTest;


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.controller.PersonController;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;





@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private static PersonService personService;

    private static PersonRepository personRepository;


    @Test
    public void getPersonTest() throws Exception {

        mockMvc.perform(get("/person")).andExpect(status().isOk());
    }
    @Test
    public void getPersonByNameTest() throws Exception {

        mockMvc.perform(get("/person/{John}")).andExpect(status().isOk());
    }
    @Test
    public void addPersonTest() throws Exception {
        Person person = new Person(
                "tonton",
                "tata",
                "rue du 8 mai",
                "lille",
                "59000",
                "0600000000",
                "tonton@gmail.com");

        mockMvc.perform(post("/person/addperson")).andExpect(status().isOk());
    }
    @Test
    public void updatePersonTest() throws Exception {
        mockMvc.perform(put("/person/tonton")).andExpect(status().isOk());
    }
    @Test
    public void deletePersonTest() throws Exception {
        mockMvc.perform(delete("/person")).andExpect(status().isOk());
    }
    @Test
    public void personsMailTest() throws Exception {
        mockMvc.perform(get("/communityEmail/lille")).andExpect(status().isOk());
    }
    @Test
    public void personListMedicationTest() throws Exception {
        mockMvc.perform(get("/personInfo/tata")).andExpect(status().isOk());
    }
    @Test
    public void childrenByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert/rue du 8 mai")).andExpect(status().isOk());
    }


}
