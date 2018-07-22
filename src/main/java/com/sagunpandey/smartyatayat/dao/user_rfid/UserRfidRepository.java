package com.sagunpandey.smartyatayat.dao.user_rfid;

import com.sagunpandey.smartyatayat.entities.UserRfid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRfidRepository extends
        CrudRepository<UserRfid, Long>,
        CustomUserRfidRepository {

    UserRfid findByUserRfidId(Long userRfidId);

    List<UserRfid> findAllByUserInfo_UserInfoId(Long userInfoId);

    UserRfid findByRfid_RfidId(Long rfidId);
}
