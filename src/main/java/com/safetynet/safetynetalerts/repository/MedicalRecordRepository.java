package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public abstract class MedicalRecordRepository implements CrudRepository<MedicalRecord, Long> {

    public Iterable<MedicalRecord> findAll(){
        JsonReadFileRepository jsonReadFileRepository = new JsonReadFileRepository();
        jsonReadFileRepository.readMedicalRecordsList();
        return findAll();
    }
}
