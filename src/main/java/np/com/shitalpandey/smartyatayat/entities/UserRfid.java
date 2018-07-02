package np.com.shitalpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class UserRfid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRfidId;

    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo userInfo;

    @OneToOne
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
