package com.sagunpandey.smartyatayat.dao.checkpoint_info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CheckpointInfoRepositoryImpl implements CustomCheckpointInfoRepository {

    @Autowired
    private EntityManager entityManager;
}
