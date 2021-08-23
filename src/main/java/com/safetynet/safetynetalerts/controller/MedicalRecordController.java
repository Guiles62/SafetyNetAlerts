package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import com.safetynet.safetynetalerts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping(value ="/medicalrecord")
    public Iterable <MedicalRecord> getMedicalRecord(){
        return medicalRecordService.getMedicalRecord();
    }

    @GetMapping(value = "/medicalrecord/id")
    public Iterable <MedicalRecord> getMedicalRecordById(long id){
        return medicalRecordService.getMedicalRecordById();
    }

    @PostMapping(value ="/medicalrecord")
    public MedicalRecord setMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    @DeleteMapping(value = "/medicalrecord")
    public void deleteMedicalRecord(long id){
        medicalRecordService.deleteMedicalRecord(id);
    }
}
