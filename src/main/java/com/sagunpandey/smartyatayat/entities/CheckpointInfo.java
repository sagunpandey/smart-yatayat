package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class CheckpointInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkpointInfoId;

    @Column(nullable = false, unique = true)
    private String checkpointName;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

    public Long getCheckpointInfoId() {
        return checkpointInfoId;
    }

    public void setCheckpointInfoId(Long checkpointInfoId) {
        this.checkpointInfoId = checkpointInfoId;
    }

    public String getCheckpointName() {
        return checkpointName;
    }

    public void setCheckpointName(String checkpointName) {
        this.checkpointName = checkpointName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
