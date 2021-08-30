package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
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
                        personObject.get("zip").toString(),
                        personObject.get("email").toString(),
                        personObject.get("phone").toString()
                ));
            }
                return listOfPerson;



    }
    public ArrayList<FireStation>readFireStationList(){

        JSONParser fireStationParser = new JSONParser();
        JSONArray fireStationList = new JSONArray();
        JSONObject fireStationObject = new JSONObject();

        try {
            Object obj = fireStationParser.parse(new FileReader(filePath));
            fireStationObject = (JSONObject) obj;
            fireStationList = (JSONArray) fireStationObject.get("firestation");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<FireStation> listOfFireStation = new ArrayList<>();
        for (int i = 0; i < fireStationList.size(); i++) {
            listOfFireStation.add(new FireStation(
                    fireStationObject.get("adress").toString(),
                    fireStationObject.get("station").toString()
            ));
        }
        return listOfFireStation;
    }

    public ArrayList<MedicalRecord> readMedicalRecordsList(){

        JSONParser medicalRecordParser = new JSONParser();
        JSONArray medicalRecordList = new JSONArray();
        JSONObject medicalRecordObject = new JSONObject();

        try {
            Object obj = medicalRecordParser.parse(new FileReader(filePath));
            medicalRecordObject = (JSONObject) obj;
            medicalRecordList = (JSONArray) medicalRecordObject.get("medicalrecords");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<MedicalRecord> listOfMedicalRecord = new ArrayList<>();
        for (int i = 0; i < medicalRecordList.size(); i++) {
            listOfMedicalRecord.add(new MedicalRecord(
                    medicalRecordObject.get("firstname").toString(),
                    medicalRecordObject.get("lastname").toString(),
                    medicalRecordObject.get("birthdate").toString(),
                    medicalRecordObject.get("medications").toString(),
                    medicalRecordObject.get("allergies").toString()
            ));
        }
        return listOfMedicalRecord;
    }

}