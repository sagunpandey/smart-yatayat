package com.sagunpandey.smartyatayat.repositories;

import com.sagunpandey.smartyatayat.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
}
