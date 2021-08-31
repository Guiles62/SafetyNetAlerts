package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class MedicalRecordRepository extends JsonReadFileRepository {

    public ArrayList<MedicalRecord> medicalRecordList(){

        return this.readMedicalRecordsList();
    }
}
