package com.sagunpandey.smartyatayat.dao.userinfo;

import com.sagunpandey.smartyatayat.entities.UserInfo;

public interface UserService {

    UserInfo save(UserInfo user);

    UserInfo findByEmail(String email);

    UserInfo findById(Long id);
}
