package com.sagunpandey.smartyatayat.dao.user_log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserLogRepositoryImpl implements CustomUserLogRepository {

    @Autowired
    private EntityManager entityManager;
}
