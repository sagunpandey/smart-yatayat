package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class Rfid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rfidId;

    @Column(nullable = false)
    private String tag0;

    @Column(nullable = false)
    private String tag1;

    @Column(nullable = false)
    private String tag2;

    @Column(nullable = false)
    private String tag3;

    @Column(nullable = false)
    private String pin;

    public Long getRfidId() {
        return rfidId;
    }

    public void setRfidId(Long rfidId) {
        this.rfidId = rfidId;
    }

    public String getTag0() {
        return tag0;
    }

    public void setTag0(String tag0) {
        this.tag0 = tag0;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
