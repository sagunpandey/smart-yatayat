package com.sagunpandey.smartyatayat.dao.user_log;

import com.sagunpandey.smartyatayat.entities.UserLog;
import org.springframework.data.repository.CrudRepository;

public interface UserLogRepository extends CrudRepository<UserLog, Long>, CustomUserLogRepository {

}
