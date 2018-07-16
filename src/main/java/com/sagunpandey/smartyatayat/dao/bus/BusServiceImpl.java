package com.sagunpandey.smartyatayat.dao.bus;

import com.sagunpandey.smartyatayat.entities.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository repository;

    @Override
    public Bus findById(Long id) {
        return repository.findByBusId(id);
    }

    @Override
    public Bus findByBusNumber(String number) {
        return repository.findByBusNumber(number);
    }

    @Override
    public List<Bus> findAll() {
        return repository.findAll();
    }
}
