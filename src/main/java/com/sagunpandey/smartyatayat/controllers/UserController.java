package com.sagunpandey.smartyatayat.controllers;

import com.google.gson.JsonObject;
import com.sagunpandey.smartyatayat.dao.userinfo.UserService;
import com.sagunpandey.smartyatayat.entities.UserInfo;
import com.sagunpandey.smartyatayat.exceptions.LoginException;
import com.sagunpandey.smartyatayat.objects.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserInfo> createStudent(@RequestBody UserInfo user) {

        user.setRole(2);
        user.setBalance(0);

        service.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login(@RequestBody LoginForm loginForm) {
            if (loginForm != null) {
            UserInfo userInfo = service.findByEmail(loginForm.getUsername());

            if(userInfo == null) {
                throw new LoginException("User not found");
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            boolean authorized = encoder.matches(loginForm.getPassword(), userInfo.getPassword());

            if(authorized) {
                JsonObject object = new JsonObject();
                object.addProperty(
                        "token",
                        encoder.encode(userInfo.getEmail() + ":" + loginForm.getPassword()));
                return object.toString();
            } else {
                throw new LoginException("Invalid Credentials");
            }
        } else {
            throw new LoginException("Invalid login request");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam("username") String username) {
        if(username != null && !username.isEmpty()) {
            UserInfo userInfo = service.findByEmail(username);

            if(userInfo != null) {
                return ResponseEntity.status(HttpStatus.OK).body(userInfo);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User '" + username +"' not found");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
    }
}
