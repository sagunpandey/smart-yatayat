package com.sagunpandey.smartyatayat.dao.user_rfid;

import com.sagunpandey.smartyatayat.entities.UserRfid;

import java.util.List;

public interface UserRfidService {

    List<UserRfid> findByUser(Long userInfoId);

    UserRfid findByRfid(Long rfidId);

    UserRfid findById(Long userRfidId);

    UserRfid save(UserRfid userRfid);
}
