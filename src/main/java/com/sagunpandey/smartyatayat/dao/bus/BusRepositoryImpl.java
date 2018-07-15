package com.sagunpandey.smartyatayat.dao.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class BusRepositoryImpl implements CustomBusRepository {

    @Autowired
    private EntityManager entityManager;
}
