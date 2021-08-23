package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FireStationController {

    @Autowired
    FireStationService fireStationService;

    @GetMapping(value = "firestation")
    public Iterable <FireStation> getFireStation(){
        return fireStationService.getFireStation();
    }

    @GetMapping(value = "firestation/{id}")
    public Optional<FireStation> getFireStationById(@PathVariable Long id){
        Optional <FireStation> firestationById = fireStationService.getFireStationById(id);
        return firestationById;
    }

    @DeleteMapping(value = "fireStation")
    public void deleteFireStation(Long id){
        fireStationService.deleteFireStation(id);
    }

    @PostMapping(value = "firestation")
    public FireStation setFireStation(FireStation fireStation){
        return fireStationService.saveFireStation(fireStation);
    }
}
