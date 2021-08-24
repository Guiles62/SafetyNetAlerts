package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FireStationService {

    @Autowired
    private FireStationRepository fireStationRepository;

    public Optional<FireStation> getFireStationById(final Long id) {

        return fireStationRepository.findById(id);
    }

    public Iterable<FireStation> getFireStation() {

        return fireStationRepository.findAll();
    }

    public void deleteFireStation(final Long id) {

        fireStationRepository.deleteById(id);
    }

    public FireStation saveFireStation(FireStation fireStation) {
        FireStation saveFireStation = fireStationRepository.save(fireStation);
        return fireStation;
    }
}
