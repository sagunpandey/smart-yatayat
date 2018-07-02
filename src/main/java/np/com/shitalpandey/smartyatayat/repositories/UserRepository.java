package np.com.shitalpandey.smartyatayat.repositories;

import np.com.shitalpandey.smartyatayat.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
}
