package com.safetynet.safetynetalerts.controller;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping(value ="medicalrecord")
    public Iterable <MedicalRecord> getMedicalRecord(){
        return medicalRecordService.getMedicalRecord();
    }

    @GetMapping(value = "medicalrecord/{id}")
    public Optional<MedicalRecord> getMedicalRecordById(@PathVariable long id){
        Optional<MedicalRecord> medicalRecordById = medicalRecordService.getMedicalRecordById(id);
        return medicalRecordById;
    }

    @PostMapping(value ="medicalrecord")
    public MedicalRecord setMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }

    @DeleteMapping(value = "medicalrecord")
    public void deleteMedicalRecord(long id){
        medicalRecordService.deleteMedicalRecord(id);
    }
}
