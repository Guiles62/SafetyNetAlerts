package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class FireStationRepository extends JsonReadFileRepository {

    public ArrayList<FireStation> fireStationList(){

        return this.readFireStationList();
    }

}
