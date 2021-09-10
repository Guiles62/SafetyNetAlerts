package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public ArrayList<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        ArrayList<MedicalRecord>addMedicalRecordList = medicalRecordService.addMedicalRecord(medicalRecord);
        return addMedicalRecordList;
    }
    @DeleteMapping(value = "medicalrecord")
    public ArrayList<MedicalRecord> deleteMedicalRecord(MedicalRecord medicalRecord){
        ArrayList<MedicalRecord>deleteMedicalRecordList = medicalRecordService.deleteMedicalRecord(medicalRecord);
        return deleteMedicalRecordList;
    }
    @GetMapping(value ="medicalrecord/{name}")
    public MedicalRecord getMedicalRecord(@PathVariable String name){
        MedicalRecord medicalRecord = medicalRecordService.findMedicalRecords(name);
        return medicalRecord;
    }
    @PutMapping(value = "medicalrecord/{name}")
    public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord,@PathVariable String name){
        MedicalRecord uMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecord,name);
        return uMedicalRecord;
    }


}
