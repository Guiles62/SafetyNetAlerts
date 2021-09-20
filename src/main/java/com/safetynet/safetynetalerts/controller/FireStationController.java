package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.DTO.FireStationByPersonAddressDTO;
import com.safetynet.safetynetalerts.DTO.FloodStationDTO;
import com.safetynet.safetynetalerts.DTO.PhoneAlertDTO;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class FireStationController {

    @Autowired
    FireStationService fireStationService;
    @Autowired
    ReadDataFromService readDataFromService;

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
    // donne la liste des personnes ainsi que leur médications par numéro de carserne
    @GetMapping(value = "flood/{station}")
    public ArrayList<FloodStationDTO> personsByFireStation(@PathVariable String station){
        ArrayList<FloodStationDTO> listOfPersonsByFireStation = fireStationService.personsByStation(station);
        return listOfPersonsByFireStation;
    }
    // donne la liste des numéros de téléphone des habitants par rapport au numéro de station
    @GetMapping(value = "phoneAlert/{station}")
    public ArrayList<PhoneAlertDTO> phoneListByStation(@PathVariable String station){
        ArrayList<PhoneAlertDTO> phoneList = fireStationService.phoneByFireStation(station);
        return phoneList;
    }
    // donne la liste des personnes par adresse avec le numéro de firestation dédiée
    @GetMapping(value = "fire/{address}")
    public ArrayList<FireStationByPersonAddressDTO> personListWithFireStationNumber(@PathVariable String address){
        ArrayList<FireStationByPersonAddressDTO> personList = fireStationService.fireStationByPersonAddress(address);
        return personList;
    }



}
