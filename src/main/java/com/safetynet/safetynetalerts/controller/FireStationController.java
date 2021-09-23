package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.DTO.*;
import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.service.FireStationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class FireStationController {

    private final static Logger logger = LogManager.getLogger("FireStationController");

    @Autowired
    FireStationService fireStationService;


    @GetMapping(value = "firestation")
    public ArrayList<FireStation> getFireStation(){
        logger.info("safetyGetFireStation");
        ArrayList<FireStation>fireStationList = fireStationService.getFireStation();
        return fireStationList;
    }
    @GetMapping(value = "firestation/{address}")
    public FireStation findFireStation (@PathVariable String address){
        logger.info("safetyFindFireStation");
        FireStation fireStation = fireStationService.findFireStation(address);
        return fireStation;
    }
    @PostMapping(value = "firestation")
    public ArrayList<FireStation> addFireStation(@RequestBody FireStation fireStation){
        logger.info("safetyAddFireStation");
        ArrayList<FireStation> addFireStationList = fireStationService.addFireStation(fireStation);
        return addFireStationList;
    }
    @PutMapping(value = "firestation/{address}")
    public FireStation updateFireStation (@RequestBody FireStation fireStation,@PathVariable String address){
        logger.info("safetyUpdateFireStation");
        FireStation uFireStation = fireStationService.updateFireStation(fireStation,address);
        return uFireStation;
    }
    @DeleteMapping(value = "firestation")
    public ArrayList<FireStation> deleteFireStation(FireStation fireStation){
        logger.info("safetyDeleteFireStation");
        ArrayList<FireStation> deleteFireStationList = fireStationService.deleteFireStation(fireStation);
        return deleteFireStationList;
    }
    // donne la liste des personnes ainsi que leur médication par numéro de caserne
    @GetMapping(value = "flood/{station}")
    public ArrayList<FloodStationDTO> personsByFireStation(@PathVariable String station){
        logger.info("safetyPersonByFireStation");
        ArrayList<FloodStationDTO> listOfPersonsByFireStation = fireStationService.personsByStation(station);
        return listOfPersonsByFireStation;
    }
    // donne la liste des numéros de téléphone des habitants par rapport au numéro de station
    @GetMapping(value = "phoneAlert/{station}")
    public ArrayList<PhoneAlertDTO> phoneListByStation(@PathVariable String station){
        logger.info("safetyPhoneListByStation");
        ArrayList<PhoneAlertDTO> phoneList = fireStationService.phoneByFireStation(station);
        return phoneList;
    }
    // donne la liste des personnes par adresse avec le numéro de firestation dédiée
    @GetMapping(value = "fire/{address}")
    public ArrayList<FireStationByPersonAddressDTO> personListWithFireStationNumber(@PathVariable String address){
        logger.info("safetyPersonListWithStationNumber");
        ArrayList<FireStationByPersonAddressDTO> personList = fireStationService.fireStationByPersonAddress(address);
        return personList;
    }
    @GetMapping(value = "/fireStation/{station}")
    public ArrayList<ListByStationNumberWithCountDTO> personsListByStation (@PathVariable String station){
        logger.info("safetyPersonListByStation");
        ArrayList<ListByStationNumberWithCountDTO> personList = fireStationService.fireStationWithCount(station);
        return personList;
    }



}
