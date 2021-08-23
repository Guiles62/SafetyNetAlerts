package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicalRecordRepository extends CrudRepository <MedicalRecord, Long> {

}
