package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class MedicalRecordRepository extends JsonReadFileRepository {

    private final static Logger logger = LogManager.getLogger("MedicalRecordRepository");

    public ArrayList<MedicalRecord> medicalRecordList(){
        logger.info("safetyGetMedicalRecordList");

        return this.readMedicalRecordsList();
    }
}
