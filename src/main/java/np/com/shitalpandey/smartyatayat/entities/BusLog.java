package np.com.shitalpandey.smartyatayat.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busLogId;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @Column(nullable = false)
    private Date time;

    private Integer passengersCount;

    @ManyToOne
    @JoinColumn(name = "checkpoint_info_id", nullable = false)
    private CheckpointInfo checkpointInfo;

    private Integer entryType;

    private Double longitude;

    private Double latitude;

    public Long getBusLogId() {
        return busLogId;
    }

    public void setBusLogId(Long busLogId) {
        this.busLogId = busLogId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(Integer passengersCount) {
        this.passengersCount = passengersCount;
    }

    public CheckpointInfo getCheckpointInfo() {
        return checkpointInfo;
    }

    public void setCheckpointInfo(CheckpointInfo checkpointInfo) {
        this.checkpointInfo = checkpointInfo;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
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

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
