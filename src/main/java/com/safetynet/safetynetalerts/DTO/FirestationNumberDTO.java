package com.safetynet.safetynetalerts.DTO;

public class FirestationNumberDTO {

    int numberOfStation;
    String firstname;
    String lastname;
    String address;
    int countOfAdult;
    int countOfChildren;

    public FirestationNumberDTO(int numberOfStation, String firstname, String lastname, String address, int countOfAdult, int countOfChildren) {
        this.numberOfStation = numberOfStation;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.countOfAdult = countOfAdult;
        this.countOfChildren = countOfChildren;
    }

    public int getNumberOfStation() {
        return numberOfStation;
    }

    public void setNumberOfStation(int numberOfStation) {
        this.numberOfStation = numberOfStation;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountOfAdult() {
        return countOfAdult;
    }

    public void setCountOfAdult(int countOfAdult) {
        this.countOfAdult = countOfAdult;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }
}
