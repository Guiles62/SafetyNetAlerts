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
}
