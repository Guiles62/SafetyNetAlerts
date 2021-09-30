package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class MedicalRecordController {

    private final static Logger logger = LogManager.getLogger("MedicalRecordController");

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping(value ="medicalrecord")
    public ArrayList<MedicalRecord> getMedicalRecord(){
        logger.info("safetyGetMedicalRecord");
        ArrayList<MedicalRecord>medicalRecordList = medicalRecordService.getMedicalRecord();
        return medicalRecordList;
    }
    @PostMapping(value = "medicalrecord/addmedicalrecord")
    public ArrayList<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        logger.info("safetyAddMedicalRecord");
        ArrayList<MedicalRecord>addMedicalRecordList = medicalRecordService.addMedicalRecord(medicalRecord);
        return addMedicalRecordList;
    }
    @DeleteMapping(value = "medicalrecord")
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        logger.info("safetyDeleteMedicalRecord");
        ArrayList<MedicalRecord>deleteMedicalRecordList = medicalRecordService.deleteMedicalRecord(medicalRecord);
        return deleteMedicalRecordList;
    }
    @GetMapping(value ="medicalrecord/{name}")
    public MedicalRecord getMedicalRecordByName(@PathVariable String name){
        logger.info("safetyGetMedicalRecordByName");
        MedicalRecord medicalRecord = medicalRecordService.findMedicalRecords(name);
        return medicalRecord;
    }
    @PutMapping(value = "medicalrecord/{name}")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord,@PathVariable String name){
        logger.info("safetyUpdateMedicalRecord");
        MedicalRecord uMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecord,name);
        return uMedicalRecord;
    }


}
