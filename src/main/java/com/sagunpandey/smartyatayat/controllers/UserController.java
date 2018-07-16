package com.sagunpandey.smartyatayat.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sagunpandey.smartyatayat.dao.userinfo.UserService;
import com.sagunpandey.smartyatayat.entities.UserInfo;
import com.sagunpandey.smartyatayat.exceptions.BadRequestException;
import com.sagunpandey.smartyatayat.exceptions.LoginException;
import com.sagunpandey.smartyatayat.exceptions.ResourceNotFoundException;
import com.sagunpandey.smartyatayat.helpers.GsonExclusionStrategy;
import com.sagunpandey.smartyatayat.objects.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

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
                Base64.Encoder encoder1 = Base64.getEncoder();

                JsonObject object = new JsonObject();
                object.addProperty(
                        "token",
                        encoder1.encodeToString(
                                (userInfo.getEmail() + ":" + loginForm.getPassword()).getBytes()
                        ));
                object.addProperty(
                        "username",
                        loginForm.getUsername()
                );
                return object.toString();
            } else {
                throw new LoginException("Invalid Credentials");
            }
        } else {
            throw new LoginException("Invalid login request");
        }
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getUser(@RequestParam("username") String username) {
        if(username != null && !username.isEmpty()) {
            UserInfo userInfo = service.findByEmail(username);

            if(userInfo != null) {
                Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new GsonExclusionStrategy()).create();
                return gson.toJson(userInfo);
            } else {
                throw new ResourceNotFoundException("User not found");
            }
        }

        throw new BadRequestException("Invalid request");
    }
}
