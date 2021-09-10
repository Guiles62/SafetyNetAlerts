package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;


@RestController
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping(value ="medicalrecord")
    public ArrayList<MedicalRecord> getMedicalRecord(){
        ArrayList<MedicalRecord>medicalRecordList = medicalRecordService.getMedicalRecord();
        return medicalRecordList;
    }
    @PostMapping(value = "medicalrecord")
    public ArrayList<MedicalRecord> addMedicalRecord(MedicalRecord medicalRecord){
        ArrayList<MedicalRecord>addMedicalRecordList = medicalRecordService.addMedicalRecord(medicalRecord);
        return addMedicalRecordList;
    }
    @DeleteMapping(value = "medicalrecord")
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        ArrayList<MedicalRecord>deleteMedicalRecordList = medicalRecordService.deleteMedicalRecord(medicalRecord);
        return deleteMedicalRecordList;
    }


}
