package com.safetynet.safetynetalerts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="medicalRecord")
public class MedicalRecord {


    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    private Date birthdate;
    private String medications;
    private String allergies;

    public MedicalRecord(String firstname, String lastname, Date birthdate, String medications, String allergies) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
