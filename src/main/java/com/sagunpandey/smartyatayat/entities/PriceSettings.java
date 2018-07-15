package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class PriceSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceSettingsId;

    @Column(nullable = false, unique = true)
    private String settingName;

    @Column
    private String settingValue;

    public Long getPriceSettingsId() {
        return priceSettingsId;
    }

    public void setPriceSettingsId(Long priceSettingsId) {
        this.priceSettingsId = priceSettingsId;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}
