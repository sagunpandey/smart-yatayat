package com.sagunpandey.smartyatayat.dao.bus_log;

import com.sagunpandey.smartyatayat.dao.bus.BusRepository;
import com.sagunpandey.smartyatayat.entities.Bus;
import com.sagunpandey.smartyatayat.entities.BusLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusLogServiceImpl implements BusLogService {

    @Autowired
    private BusLogRepository repository;

    @Autowired
    private BusRepository busRepository;

    @Override
    public BusLog save(BusLog busLog) {
        return repository.save(busLog);
    }

    @Override
    public BusLog findLatestLogForExitEvent(Long busId) {
        return repository.findFirstByBus_BusIdAndEntryTypeOrderByBusLogIdDesc(busId, 0);
    }

    @Override
    public List<BusLog> findLatestLogForExitEventForAllBuses() {
        List<Bus> buses = busRepository.findAll();

        List<BusLog> logs = new ArrayList<>();
        for(Bus bus: buses) {
            BusLog log = findLatestLogForExitEvent(bus.getBusId());
            if(log != null)
                logs.add(log);
        }

        return logs;
    }
}
