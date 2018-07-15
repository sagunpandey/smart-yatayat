package com.sagunpandey.smartyatayat.dao.price_settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PriceSettingsRepositoryImpl implements CustomPriceSettingsRepository {

    @Autowired
    private EntityManager entityManager;
}
