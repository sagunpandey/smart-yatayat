package com.sagunpandey.smartyatayat.dao.userinfo;

import com.sagunpandey.smartyatayat.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserInfo save(UserInfo user) {
        return repository.save(user);
    }

    @Override
    public UserInfo findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserInfo findById(Long id) {
        return repository.findByUserInfoId(id);
    }
}
