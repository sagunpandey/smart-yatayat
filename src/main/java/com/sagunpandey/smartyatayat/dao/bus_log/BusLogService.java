package com.sagunpandey.smartyatayat.dao.bus_log;

import com.sagunpandey.smartyatayat.entities.BusLog;

import java.util.List;

public interface BusLogService {

    BusLog save(BusLog busLog);

    BusLog findLatestLogForExitEvent(Long busId);

    List<BusLog> findLatestLogForExitEventForAllBuses();
}
