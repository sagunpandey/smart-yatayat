package com.sagunpandey.smartyatayat.dao.userinfo;

import com.sagunpandey.smartyatayat.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long>, CustomUserInfoRepository {

    UserInfo findByEmail(String email);

    UserInfo findByUserInfoId(Long userInfoId);
}
