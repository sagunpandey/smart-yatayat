package com.sagunpandey.smartyatayat.dao.bus_log;

import com.sagunpandey.smartyatayat.entities.BusLog;
import org.springframework.data.repository.CrudRepository;

public interface BusLogRepository extends CrudRepository<BusLog, Long> {


    BusLog findFirstByBus_BusIdAndEntryTypeOrderByBusLogIdDesc(Long id, Integer entryType);
}
