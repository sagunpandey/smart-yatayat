package com.sagunpandey.smartyatayat.dao.user_log;

import com.sagunpandey.smartyatayat.entities.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogRepository repository;

    @Override
    public UserLog save(UserLog userLog) {
        return repository.save(userLog);
    }
}
