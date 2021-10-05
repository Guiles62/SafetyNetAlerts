package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class MedicalRecordRepository extends JsonReadFileRepository {

    private final static Logger logger = LogManager.getLogger("MedicalRecordRepository");

    public ArrayList<MedicalRecord> getMedicalRecordList(){
        logger.info("safetyGetMedicalRecordList");

        return this.readMedicalRecordsList();
    }
    public ArrayList<MedicalRecord> addMedicalRecord(MedicalRecord medicalRecord){
        logger.info("safetyAddMedicalRecord");
        ArrayList<MedicalRecord> addMedicalRecordList = getMedicalRecordList();
        addMedicalRecordList.add(medicalRecord);
        return addMedicalRecordList;
    }
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        logger.info("safetyDeleteMedicalRecord");
        ArrayList<MedicalRecord> deleteMedicalRecordList = getMedicalRecordList();
        deleteMedicalRecordList.remove(medicalRecord);
        return deleteMedicalRecordList;
    }
    public MedicalRecord findMedicalRecords(String name) {
        logger.info("safetyFindMedicalRecords");
        ArrayList<MedicalRecord> medicalRecordsName = getMedicalRecordList();
        for (int i = 0; i < medicalRecordsName.size(); i++) {
            if (medicalRecordsName.get(i).getFirstname().toLowerCase().contains(name)) {
                medicalRecordsName.get(i);
            }
            return medicalRecordsName.get(i);
        }
        return findMedicalRecords(name);
    }
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord,String name) {
        logger.info("safetyUpdateMedicalRecord");
        ArrayList<MedicalRecord> updateAMedicalRecord = getMedicalRecordList();
        for (int i = 0; i < updateAMedicalRecord.size(); i++) {
            if (updateAMedicalRecord.get(i).getFirstname().contains(name)) {
                updateAMedicalRecord.set(i, medicalRecord);
            }
            return updateAMedicalRecord.get(i);
        }
        return updateMedicalRecord(medicalRecord,name);
    }
}
