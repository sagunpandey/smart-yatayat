package com.sagunpandey.smartyatayat.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sagunpandey.smartyatayat.helpers.Exclude;

import javax.persistence.*;

@Entity
public class UserRfid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRfidId;

    @Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo userInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rfid_id", nullable = false)
    private Rfid rfid;

    @JoinColumn(nullable = false)
    private Integer active;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Rfid getRfid() {
        return rfid;
    }

    public void setRfid(Rfid rfid) {
        this.rfid = rfid;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Long getUserRfidId() {
        return userRfidId;
    }

    public void setUserRfidId(Long userRfidId) {
        this.userRfidId = userRfidId;
    }
}
