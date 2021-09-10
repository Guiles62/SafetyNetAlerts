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
    public ArrayList<FireStation> deleteFireStation(FireStation fireStation){
        ArrayList<FireStation> deleteFireStationList = fireStationRepository.fireStationList();
        deleteFireStationList.remove(fireStation);
        return deleteFireStationList;
    }
    public FireStation findFireStation (String address) {
        ArrayList<FireStation> fireStationName = fireStationRepository.fireStationList();
        for (int i = 0; i < fireStationName.size(); i++) {
            if (fireStationName.get(i).getAddress().toLowerCase().contains(address)) {
                FireStation fireStationFind = fireStationName.get(i);
                return fireStationFind;
            }
        }
        return findFireStation(address);
    }
    public FireStation updateFireStation (FireStation fireStation,String address){
        ArrayList<FireStation> updateFireStation = fireStationRepository.fireStationList();
        FireStation uFireStation = findFireStation(address);
        for (int i = 0; i < updateFireStation.size(); i++) {
            if (updateFireStation.get(i).getAddress().contains(uFireStation.getAddress())) {
                updateFireStation.set(i, fireStation);
                return updateFireStation.get(i);
            }

        }
        return updateFireStation(fireStation,address);
    }
}
