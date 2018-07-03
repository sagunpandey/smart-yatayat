package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(nullable = false, unique = true)
    private String busNumber;

    @Column(nullable = false)
    private Integer totalSeats;

    @Column(nullable = false)
    private Integer standingCapacity = 0;

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getStandingCapacity() {
        return standingCapacity;
    }

    public void setStandingCapacity(Integer standingCapacity) {
        this.standingCapacity = standingCapacity;
    }
}
