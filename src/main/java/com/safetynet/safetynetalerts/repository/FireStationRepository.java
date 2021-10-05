package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class FireStationRepository extends JsonReadFileRepository {

    private final static Logger logger = LogManager.getLogger("PersonRepository");

    public ArrayList<FireStation> getFireStationList(){
        logger.info("safetyGetFireStationList");
        return this.readFireStationList();
    }

    public ArrayList<FireStation> addFireStation(FireStation fireStation) {
        logger.info("safetyAddFireStation");
        ArrayList<FireStation> addFireStationList = getFireStationList();
        addFireStationList.add(fireStation);
        return addFireStationList;
    }

    public ArrayList<FireStation> deleteFireStation(FireStation fireStation) {
        logger.info("safetyDeleteFireStation");
        ArrayList<FireStation> deleteFireStationList = getFireStationList();
        deleteFireStationList.remove(fireStation);
        return deleteFireStationList;
    }

    public FireStation findFireStation(String address) {
        logger.info("safetyFindFireStation");
        ArrayList<FireStation> fireStationName = getFireStationList();
        for (int i = 0; i < fireStationName.size(); i++) {
            if (fireStationName.get(i).getAddress().toLowerCase().contains(address)) {
                fireStationName.get(i);
            }
            return fireStationName.get(i);
        }
        return findFireStation(address);
    }

    public FireStation updateFireStation(FireStation fireStation, String address) {
        logger.info("safetyUpdateFireStation");
        ArrayList<FireStation> updateFireStation = getFireStationList();
        for (int i = 0; i < updateFireStation.size(); i++) {
            if (updateFireStation.get(i).getAddress().contains(address)) {
                updateFireStation.set(i, fireStation);
            }
            return updateFireStation.get(i);
        }
        return updateFireStation(fireStation, address);
    }


}
