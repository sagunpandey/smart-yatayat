package com.sagunpandey.smartyatayat.objects;

import java.util.Date;

public class BusStatusCheckpointExit {

    private String busNumber;

    private Integer totalPassesngers;

    private String availability;

    private String checkpoint;

    private Date time;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getTotalPassesngers() {
        return totalPassesngers;
    }

    public void setTotalPassesngers(Integer totalPassesngers) {
        this.totalPassesngers = totalPassesngers;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
