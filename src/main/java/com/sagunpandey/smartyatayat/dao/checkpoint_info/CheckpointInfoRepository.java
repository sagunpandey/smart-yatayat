package com.sagunpandey.smartyatayat.dao.checkpoint_info;

import com.sagunpandey.smartyatayat.entities.CheckpointInfo;
import org.springframework.data.repository.CrudRepository;

public interface CheckpointInfoRepository extends CrudRepository<CheckpointInfo, Long>, CustomCheckpointInfoRepository {

}
