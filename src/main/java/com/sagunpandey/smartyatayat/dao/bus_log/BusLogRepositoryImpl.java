package com.sagunpandey.smartyatayat.dao.bus_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BusLogRepositoryImpl implements CustomBusLogRepository {

    @Autowired
    private EntityManager entityManager;
}
