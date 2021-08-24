package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public Optional<MedicalRecord> getMedicalRecordById(final Long id) {

        return medicalRecordRepository.findById(id);
    }

    public Iterable<MedicalRecord> getMedicalRecord() {

        return medicalRecordRepository.findAll();
    }

    public void deleteMedicalRecord(final Long id) {

        medicalRecordRepository.deleteById(id);
    }

    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
        return savedMedicalRecord;
    }

}
