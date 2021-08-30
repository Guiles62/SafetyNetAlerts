package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public abstract class FireStationRepository implements CrudRepository<FireStation, Long> {
    JsonReadFileRepository jsonReadFileRepository = new JsonReadFileRepository();

    public ArrayList<FireStation> fireStationList () {
        jsonReadFileRepository.readFireStationList();
        return fireStationList();
    }
}
