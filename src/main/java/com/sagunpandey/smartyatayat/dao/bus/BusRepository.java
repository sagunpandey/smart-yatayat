package com.sagunpandey.smartyatayat.dao.bus;

import com.sagunpandey.smartyatayat.dao.bus_log.CustomBusLogRepository;
import com.sagunpandey.smartyatayat.entities.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepository extends CrudRepository<Bus, Long>, CustomBusLogRepository {

}
