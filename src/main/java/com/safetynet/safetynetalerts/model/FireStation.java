package com.safetynet.safetynetalerts.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fireStation")
public class FireStation {

    @Id
    private long id;
    @Column(name="address")
    private String address;
    private int station;

    public FireStation(long id, String address, int station) {
        this.id = id;
        this.address = address;
        this.station = station;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }
}
