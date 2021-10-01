package com.safetynet.safetynetalerts.serviceTest;

import com.safetynet.safetynetalerts.model.FireStation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.MedicalRecordRepository;
import com.safetynet.safetynetalerts.service.MedicalRecordService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MedicalRecordServiceTest {


    private ArrayList<MedicalRecord>medicalList;
    private static MedicalRecordService medicalRecordService;
    @Mock
    private static MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    void setup() {
        medicalRecordService = new MedicalRecordService(medicalRecordRepository);
        medicalList = new ArrayList<>();
        MedicalRecord medicalRecord = new MedicalRecord(
                "guillaume",
                "morph",
                "06/03/1983",
                "",
                "");
        medicalList.add(medicalRecord);

        when(medicalRecordRepository.getMedicalRecordList()).thenReturn(medicalList);

    }
    @AfterEach
    void clearList() {

        medicalList.clear();

    }
    @Test
    public void getMedicalRecordListTest() {

        assertEquals(1,medicalRecordService.getMedicalRecord().size());
    }
    @Test
    public void addMedicalRecordTest() {
        MedicalRecord medicalRecord1 = new MedicalRecord("tonton","tata","01/04/1994","doliprane","");
        when(medicalRecordRepository.addMedicalRecord(medicalRecord1)).thenReturn(medicalList);
        medicalRecordService.addMedicalRecord(medicalRecord1);
        verify(medicalRecordRepository,times(1)).addMedicalRecord(medicalRecord1);
    }
    @Test
    public void deleteMedicalRecordTest() {
        MedicalRecord medicalRecord2 = new MedicalRecord("tonton","tata","01/04/1994","doliprane","");
        when(medicalRecordRepository.deleteMedicalRecord(medicalRecord2)).thenReturn(medicalList);
        medicalRecordService.deleteMedicalRecord(medicalRecord2);
        verify(medicalRecordRepository,times(1)).deleteMedicalRecord(medicalRecord2);
    }
    @Test
    public void findMedicalRecordByNameTest() {
        MedicalRecord medicalRecord3 = new MedicalRecord("guillaume","tata","01/04/1994","doliprane","");
        when(medicalRecordRepository.findMedicalRecords("guillaume")).thenReturn(medicalRecord3);
        medicalRecordService.findMedicalRecords("guillaume");
        verify(medicalRecordRepository,times(1)).findMedicalRecords("guillaume");
    }
    @Test
    public void updateMedicalRecordTest() {
        MedicalRecord medicalRecord4 = new MedicalRecord(
                "guillaume",
                "morph",
                "06/03/1983",
                "",
                "bad persons");
        when(medicalRecordRepository.updateMedicalRecord(medicalRecord4,"guillaume")).thenReturn(medicalRecord4);
        medicalRecordService.updateMedicalRecord(medicalRecord4,"guillaume");
        verify(medicalRecordRepository,times(1)).updateMedicalRecord(medicalRecord4,"guillaume");
    }
}
