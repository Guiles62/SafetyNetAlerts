package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;


@RestController
public class FireStationController {

    @Autowired
    FireStationService fireStationService;

    @GetMapping(value = "firestation")
    public ArrayList<FireStation> getFireStation(){
        ArrayList<FireStation>fireStationList = fireStationService.getFireStation();
        return fireStationList;
    }
    @PostMapping(value = "firestation")
    public ArrayList<FireStation> addFireStation(FireStation fireStation){
        ArrayList<FireStation> addFireStationList = fireStationService.addFireStation(fireStation);
        return addFireStationList;
    }
    @DeleteMapping(value = "firestation")
    public ArrayList<FireStation> deleteFireStation(FireStation fireStation){
        ArrayList<FireStation> deleteFireStationList = fireStationService.deleteFirestation(fireStation);
        return deleteFireStationList;
    }


}
