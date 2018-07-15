package com.sagunpandey.smartyatayat.dao.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserInfoRepositoryImpl implements CustomUserInfoRepository {

    @Autowired
    private EntityManager entityManager;
}
