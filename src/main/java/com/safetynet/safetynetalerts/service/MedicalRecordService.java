package com.safetynet.safetynetalerts.service;


import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class MedicalRecordService {

    private final static Logger logger = LogManager.getLogger("MedicalRecordService");

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public ArrayList<MedicalRecord> getMedicalRecord() {
        logger.info("safetyGetMedicalRecord");
        ArrayList<MedicalRecord> getMedicalRecordList = medicalRecordRepository.getMedicalRecordList();
        return getMedicalRecordList;
    }
    public ArrayList<MedicalRecord> addMedicalRecord(MedicalRecord medicalRecord){
        logger.info("safetyAddMedicalRecord");
        ArrayList<MedicalRecord> addMedicalRecordList = medicalRecordRepository.addMedicalRecord(medicalRecord);
        return addMedicalRecordList;
    }
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        logger.info("safetyDeleteMedicalRecord");
        ArrayList<MedicalRecord> deleteMedicalRecordList = medicalRecordRepository.deleteMedicalRecord(medicalRecord);
        return deleteMedicalRecordList;
    }
    public MedicalRecord findMedicalRecords(String name) {
        logger.info("safetyFindMedicalRecords");
        MedicalRecord medicalRecordsName = medicalRecordRepository.findMedicalRecords(name);
        return medicalRecordsName;
    }
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord,String name) {
        logger.info("safetyUpdateMedicalRecord");
        MedicalRecord updateAMedicalRecord = medicalRecordRepository.updateMedicalRecord(medicalRecord, name);
        return updateAMedicalRecord;
    }



}
