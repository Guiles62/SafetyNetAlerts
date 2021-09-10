package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MedicalRecordService {
    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public ArrayList<MedicalRecord> getMedicalRecord() {
        ArrayList<MedicalRecord> getMedicalRecordList = medicalRecordRepository.medicalRecordList();
        return getMedicalRecordList;
    }
    public ArrayList<MedicalRecord> addMedicalRecord(MedicalRecord medicalRecord){
        ArrayList<MedicalRecord> addMedicalRecordList = medicalRecordRepository.medicalRecordList();
        addMedicalRecordList.add(medicalRecord);
        return addMedicalRecordList;
    }
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        ArrayList<MedicalRecord> deleteMedicalRecordList = medicalRecordRepository.medicalRecordList();
        deleteMedicalRecordList.remove(medicalRecord);
        return deleteMedicalRecordList;
    }



}
