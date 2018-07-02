package np.com.shitalpandey.smartyatayat.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userLogId;

    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo userInfo;

    @Column(nullable = false)
    private Date time;

    @ManyToOne
    @JoinColumn(name = "checkpoint_info_id", nullable = false)
    private CheckpointInfo checkpointInfo;

    @Column(nullable = false)
    private Integer entryType;

    public Long getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(Long userLogId) {
        this.userLogId = userLogId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public CheckpointInfo getCheckpointInfo() {
        return checkpointInfo;
    }

    public void setCheckpointInfo(CheckpointInfo checkpointInfo) {
        this.checkpointInfo = checkpointInfo;
    }
}
