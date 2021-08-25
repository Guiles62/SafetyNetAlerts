package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



@Repository
public class JsonReadFileRepository {

    protected static String filePath = "data.json";

    public ArrayList<Person> readPersonList() {


        JSONParser personParser = new JSONParser();
        JSONArray personList = new JSONArray();
        JSONObject personObject = new JSONObject();

        try {
            Object obj = personParser.parse(new FileReader(filePath));
            personObject = (JSONObject) obj;
            personList = (JSONArray) personObject.get("person");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ArrayList<Person> listOfPerson = new ArrayList<>();
            for (int i = 0; i < personList.size(); i++) {
                listOfPerson.add(new Person(
                        personObject.get("firstname").toString(),
                        personObject.get("lastName").toString(),
                        personObject.get("address").toString(),
                        personObject.get("city").toString(),
                        (Integer) personObject.get("zip"),
                        personObject.get("email").toString(),
                        personObject.get("phone").toString()
                ));
            }
                return listOfPerson;



    }

}