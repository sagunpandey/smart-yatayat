package com.sagunpandey.smartyatayat.dao.bus_log;

import com.sagunpandey.smartyatayat.entities.BusLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusLogServiceImpl implements BusLogService {

    @Autowired
    private BusLogRepository repository;

    @Override
    public BusLog save(BusLog busLog) {
        return repository.save(busLog);
    }
}
