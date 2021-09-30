package com.safetynet.safetynetalerts.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;





@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private static PersonRepository personRepository;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getPersonsTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/person")).andExpect(status().isOk());
    }
    @Test
    public void getPersonByNameTest() throws Exception {

        mockMvc.perform(get("/person?name=tonton")).andExpect(status().isOk());
    }

    @Test
    public void addPersonTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/person/addperson")
                .content(asJsonString(new Person(
                        "tonton",
                        "tata",
                        "rue du 8 mai",
                        "lille",
                        "59000",
                        "0600000000",
                        "tonton@gmail.com")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updatePersonTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.put("/person/tonton")
                        .content(asJsonString(new Person(
                                "tonton",
                                "tata",
                                "rue du 8 mai",
                                "lille",
                                "59000",
                                "0600000000",
                                "tonton@gmail.com")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());

    }
    @Test
    public void deletePersonTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/person")).andExpect(status().isOk());
    }
    @Test
    public void personsMailTest() throws Exception {

        mockMvc.perform(get("/communityEmail?city=lille")).andExpect(status().isOk());
    }
    @Test
    public void personListMedicationTest() throws Exception {

        mockMvc.perform(get("/personInfo?lastname=tata")).andExpect(status().isOk());
    }

    @Test
    public void getChildrenByAddress() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/childAlert?address=AAAA")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
    }

}
