package np.com.shitalpandey.smartyatayat.controllers;

import np.com.shitalpandey.smartyatayat.entities.UserInfo;
import np.com.shitalpandey.smartyatayat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(name = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserInfo createStudent(@RequestBody UserInfo user) {

        user.setRole(2);
        user.setBalance(0);

        userRepository.save(user);
        return user;
    }
}
