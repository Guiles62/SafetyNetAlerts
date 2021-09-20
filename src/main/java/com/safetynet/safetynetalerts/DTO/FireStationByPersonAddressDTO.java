package com.safetynet.safetynetalerts.DTO;

public class FireStationByPersonAddressDTO {

    String firstname;
    String lastname;
    String phone;
    String birthdate;
    String medications;
    String allergies;
    String fireStation;

    public FireStationByPersonAddressDTO(String firstname, String lastname, String phone, String birthdate, String medications, String allergies, String numberOfStation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
        this.fireStation = numberOfStation;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
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

    public String getFireStation() {
        return fireStation;
    }

    public void setFireStation(String fireStation) {
        this.fireStation = fireStation;
    }
}
