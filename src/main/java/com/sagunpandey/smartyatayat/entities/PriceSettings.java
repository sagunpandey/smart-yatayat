package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class PriceSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceSettingsId;

    @Column(nullable = false)
    private Integer checkpointRate;

    @Column(nullable = false)
    private Integer minimumBalanceAllowed;

    public Long getPriceSettingsId() {
        return priceSettingsId;
    }

    public void setPriceSettingsId(Long priceSettingsId) {
        this.priceSettingsId = priceSettingsId;
    }

    public Integer getCheckpointRate() {
        return checkpointRate;
    }

    public void setCheckpointRate(Integer checkpointRate) {
        this.checkpointRate = checkpointRate;
    }

    public Integer getMinimumBalanceAllowed() {
        return minimumBalanceAllowed;
    }

    public void setMinimumBalanceAllowed(Integer minimumBalanceAllowed) {
        this.minimumBalanceAllowed = minimumBalanceAllowed;
    }
}
