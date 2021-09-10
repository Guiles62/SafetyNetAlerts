package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.MedicalRecord;
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
    public MedicalRecord findMedicalRecords(String name) {
        ArrayList<MedicalRecord> medicalRecordsName = medicalRecordRepository.medicalRecordList();
        for (int i = 0; i < medicalRecordsName.size(); i++) {
            if (medicalRecordsName.get(i).getFirstname().toLowerCase().contains(name)) {
                MedicalRecord medicalRecordFind = medicalRecordsName.get(i);
                return medicalRecordFind;
            }
        }
        return findMedicalRecords(name);
    }
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord,String name) {
        ArrayList<MedicalRecord> updateAMedicalRecord = medicalRecordRepository.medicalRecordList();
        MedicalRecord uMedicalRecord = findMedicalRecords(name);
        for (int i = 0; i < updateAMedicalRecord.size(); i++) {
            if (updateAMedicalRecord.get(i).getFirstname().contains(uMedicalRecord.getFirstname())) {
                updateAMedicalRecord.set(i, medicalRecord);
                return updateAMedicalRecord.get(i);
            }

        }
        return updateMedicalRecord(medicalRecord,name);
    }



}
