package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class Rfid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rfidId;

    @Column(nullable = false)
    private Integer tag0;

    @Column(nullable = false)
    private Integer tag1;

    @Column(nullable = false)
    private Integer tag2;

    @Column(nullable = false)
    private Integer tag3;

    @Column(nullable = false)
    private Integer pin;

    public Long getRfidId() {
        return rfidId;
    }

    public void setRfidId(Long rfidId) {
        this.rfidId = rfidId;
    }

    public Integer getTag0() {
        return tag0;
    }

    public void setTag0(Integer tag0) {
        this.tag0 = tag0;
    }

    public Integer getTag1() {
        return tag1;
    }

    public void setTag1(Integer tag1) {
        this.tag1 = tag1;
    }

    public Integer getTag2() {
        return tag2;
    }

    public void setTag2(Integer tag2) {
        this.tag2 = tag2;
    }

    public Integer getTag3() {
        return tag3;
    }

    public void setTag3(Integer tag3) {
        this.tag3 = tag3;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
