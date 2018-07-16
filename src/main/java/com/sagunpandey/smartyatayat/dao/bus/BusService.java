package com.sagunpandey.smartyatayat.dao.bus;

import com.sagunpandey.smartyatayat.entities.Bus;

import java.util.List;

public interface BusService {

    Bus findById(Long id);

    Bus findByBusNumber(String number);

    List<Bus> findAll();
}
