package com.safetynet.safetynetalerts.controllerTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.safetynet.safetynetalerts.DTO.ChildrenListDTO;
import com.safetynet.safetynetalerts.controller.PersonController;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonRepository;
import com.safetynet.safetynetalerts.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;


@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private static PersonService personService;
    @Mock
    private static PersonRepository personRepository;



    @Test
    public void getPersonTest() throws Exception {

        mockMvc.perform(get("/person")).andExpect(status().isOk());
    }
    @Test
    public void getPersonByNameTest() throws Exception {
        Person person = new Person(
                "tonton",
                "tata",
                "rue du 8 mai",
                "lille",
                "59000",
                "0600000000",
                "tonton@gmail.com");
        when(personService.findPerson("tonton")).thenReturn(person);

        mockMvc.perform(get("/person?name=tonton")).andExpect(status().isOk());
    }
    @Test
    public void addPersonTest() throws Exception {
        ArrayList<Person> personList = new ArrayList<>();
        Person person = new Person(
                "tonton",
                "tata",
                "rue du 8 mai",
                "lille",
                "59000",
                "0600000000",
                "tonton@gmail.com");
        personList.add(person);

        when(personService.addPerson(person)).thenReturn(personList);

        mockMvc.perform(post("/person/addPerson")).andExpect(status().isOk());
    }
    @Test
    public void updatePersonTest() throws Exception {
        Person person = new Person(
                "tonton",
                "tata",
                "rue du 8 mai",
                "lille",
                "59000",
                "0600000000",
                "tonton@gmail.com");
        when (personService.updatePerson(person, "tonton")).thenReturn(person);
        mockMvc.perform(put("/person?name=tonton")).andExpect(status().isOk());
    }
    @Test
    public void deletePersonTest() throws Exception {
        mockMvc.perform(delete("/person")).andExpect(status().isOk());
    }
    @Test
    public void personsMailTest() throws Exception {
        ArrayList<String> mailList = new ArrayList<>();
        when(personService.getMailPersons("lille")).thenReturn(mailList);
        mockMvc.perform(get("/communityEmail?city=lille")).andExpect(status().isOk());
    }
    @Test
    public void personListMedicationTest() throws Exception {
        mockMvc.perform(get("/personInfo/tata")).andExpect(status().isOk());
    }

    @Test
    public void getChildrenByAddress() throws Exception {

        ArrayList<ChildrenListDTO> childrenByAddressDTOList = new ArrayList<ChildrenListDTO>();
        when(personService.childrenList("AAAA")).thenReturn(childrenByAddressDTOList);

        MvcResult mvcResult = this.mockMvc.perform(get("/childAlert?address=AAAA")).andDo(print()).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(status, 200);
    }

}
