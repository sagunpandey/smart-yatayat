package com.sagunpandey.smartyatayat.dao.user_rfid;

import com.sagunpandey.smartyatayat.entities.UserRfid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRfidServiceImpl implements UserRfidService {

    @Autowired
    private UserRfidRepository repository;

    @Override
    public List<UserRfid> findByUser(Long userInfoId) {
        return repository.findAllByUserInfo_UserInfoId(userInfoId);
    }

    @Override
    public UserRfid findByRfid(Long rfidId) {
        return repository.findByRfid_RfidId(rfidId);
    }

    @Override
    public UserRfid findById(Long userRfidId) {
        return repository.findByUserRfidId(userRfidId);
    }

    @Override
    public UserRfid save(UserRfid userRfid) {
        return repository.save(userRfid);
    }
}
