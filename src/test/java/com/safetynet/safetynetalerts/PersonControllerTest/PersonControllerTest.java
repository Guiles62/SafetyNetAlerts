package com.safetynet.safetynetalerts.PersonControllerTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.safetynet.safetynetalerts.controller.PersonController;
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
    public void GetPersonByNameTest() throws Exception {
        mockMvc.perform(get("/person/John")).andExpect(status().isOk());
    }
}
