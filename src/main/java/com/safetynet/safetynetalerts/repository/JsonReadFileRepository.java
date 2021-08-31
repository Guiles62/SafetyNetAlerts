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

    protected static String filePath = "src/main/resources/json/data.json";

    public ArrayList<Person> readPersonList() {


        JSONParser personParser = new JSONParser();
        JSONArray personList = new JSONArray();
        JSONObject personObject = new JSONObject();

        try {
            Object obj = personParser.parse(new FileReader(filePath));
            personObject = (JSONObject) obj;
            personList = (JSONArray) personObject.get("persons");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        ArrayList<Person> listOfPerson = new ArrayList<>();
            for (int i = 0; i < personList.size(); i++) {
                JSONObject personListValue = (JSONObject) personList.get(i);
                listOfPerson.add(new Person(
                        personListValue.get("firstName").toString(),
                        personListValue.get("lastName").toString(),
                        personListValue.get("address").toString(),
                        personListValue.get("city").toString(),
                        personListValue.get("zip").toString(),
                        personListValue.get("email").toString(),
                        personListValue.get("phone").toString()));

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
            fireStationList = (JSONArray) fireStationObject.get("firestations");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ArrayList<FireStation> listOfFireStation = new ArrayList<>();
        for (int i = 0; i < fireStationList.size(); i++) {
            JSONObject fireStationListValue = (JSONObject) fireStationList.get(i);
            listOfFireStation.add(new FireStation(
                    fireStationListValue.get("address").toString(),
                    fireStationListValue.get("station").toString()
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
            JSONObject medicalRecordListValue = (JSONObject) medicalRecordList.get(i);
            listOfMedicalRecord.add(new MedicalRecord(
                    medicalRecordListValue.get("firstName").toString(),
                    medicalRecordListValue.get("lastName").toString(),
                    medicalRecordListValue.get("birthdate").toString(),
                    medicalRecordListValue.get("medications").toString(),
                    medicalRecordListValue.get("allergies").toString()
            ));
        }
        return listOfMedicalRecord;
    }

}