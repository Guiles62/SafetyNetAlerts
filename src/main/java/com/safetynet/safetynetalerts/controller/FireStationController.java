package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping(value = "firestation/{address}")
    public FireStation findFireStation (@PathVariable String address){
        FireStation fireStation = fireStationService.findFireStation(address);
        return fireStation;
    }
    @PostMapping(value = "firestation")
    public ArrayList<FireStation> addFireStation(@RequestBody FireStation fireStation){
        ArrayList<FireStation> addFireStationList = fireStationService.addFireStation(fireStation);
        return addFireStationList;
    }
    @PutMapping(value = "firestation/{address}")
    public FireStation updateFireStation (@RequestBody FireStation fireStation,@PathVariable String address){
        FireStation uFireStation = fireStationService.updateFireStation(fireStation,address);
        return uFireStation;
    }
    @DeleteMapping(value = "firestation")
    public ArrayList<FireStation> deleteFireStation(FireStation fireStation){
        ArrayList<FireStation> deleteFireStationList = fireStationService.deleteFireStation(fireStation);
        return deleteFireStationList;
    }


}
