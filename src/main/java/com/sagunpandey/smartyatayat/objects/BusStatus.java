package com.sagunpandey.smartyatayat.objects;

public class BusStatus {

    private String busNumber;

    private Integer totalPassengers;

    private String availability;

    private String checkpoint;

    private String leftAt;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getTotalPassengers() {
        return totalPassengers;
    }

    public void setTotalPassengers(Integer totalPassengers) {
        this.totalPassengers = totalPassengers;
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

    public String getLeftAt() {
        return leftAt;
    }

    public void setLeftAt(String leftAt) {
        this.leftAt = leftAt;
    }
}
