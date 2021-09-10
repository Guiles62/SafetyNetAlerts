package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class FireStationService {

    @Autowired
    FireStationRepository fireStationRepository;

    public ArrayList<FireStation> getFireStation() {
        ArrayList<FireStation> getFireStationList = fireStationRepository.fireStationList();
        return getFireStationList;
    }

    public ArrayList<FireStation> addFireStation(FireStation fireStation){
        ArrayList<FireStation> addFireStationList = fireStationRepository.fireStationList();
        addFireStationList.add(fireStation);
        return addFireStationList;
    }
    public ArrayList<FireStation> deleteFirestation(FireStation fireStation){
        ArrayList<FireStation> deleteFireStationList = fireStationRepository.fireStationList();
        deleteFireStationList.remove(fireStation);
        return deleteFireStationList;
    }
}
