package com.sagunpandey.smartyatayat.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sagunpandey.smartyatayat.dao.user_rfid.UserRfidService;
import com.sagunpandey.smartyatayat.dao.userinfo.UserService;
import com.sagunpandey.smartyatayat.entities.UserInfo;
import com.sagunpandey.smartyatayat.entities.UserRfid;
import com.sagunpandey.smartyatayat.exceptions.BadRequestException;
import com.sagunpandey.smartyatayat.exceptions.LoginException;
import com.sagunpandey.smartyatayat.exceptions.ResourceNotFoundException;
import com.sagunpandey.smartyatayat.helpers.GsonExclusionStrategy;
import com.sagunpandey.smartyatayat.objects.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;
    private UserRfidService userRfidService;

    private Gson gson;

    @Autowired
    public UserController(UserService service, UserRfidService userRfidService) {
        this.service = service;
        this.userRfidService = userRfidService;

        gson = new GsonBuilder()
                .addSerializationExclusionStrategy(new GsonExclusionStrategy()).create();
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String createUser(@RequestBody UserInfo user) {

        user.setRole(2);
        user.setBalance(0);
        user.setPassword(UserInfo.PASSWORD_ENCODER.encode(user.getPassword()));

        return gson.toJson(service.save(user));
    }

    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateUser(@RequestBody UserInfo user) {
        Long id = user.getUserInfoId();

        if(id == null) {
            throw new BadRequestException("User update failed");
        }

        UserInfo u = service.findById(id);
        if(u == null) {
            throw new ResourceNotFoundException("User not found");
        }

        u.setFirstName(user.getFirstName());
        u.setMiddleName(user.getMiddleName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setBalance(user.getBalance());
        if(user.getPassword() != null && !user.getPassword().isEmpty())
            u.setPassword(UserInfo.PASSWORD_ENCODER.encode(user.getPassword()));

        return gson.toJson(service.save(u));
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

            boolean authorized = UserInfo.PASSWORD_ENCODER.matches(loginForm.getPassword(), userInfo.getPassword());

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
                return gson.toJson(userInfo);
            } else {
                throw new ResourceNotFoundException("User not found");
            }
        }

        throw new BadRequestException("Invalid request");
    }

    @PostMapping(
            value = "/card/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String addCard(@RequestBody UserRfid userRfid) {
        if(userRfid == null ||
                userRfid.getUserInfo() == null ||
                userRfid.getUserInfo().getUserInfoId() == null ||
                userRfid.getRfid() == null) {
            throw new BadRequestException("Invalid request");
        }

        userRfid.setActive(0);

        userRfid = userRfidService.save(userRfid);

        return gson.toJson(userRfid);
    }

    @PutMapping(
            value = "/card/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateCard(@RequestBody UserRfid userRfid) {
        if(userRfid == null || userRfid.getUserRfidId() == null || userRfid.getRfid() == null) {
            throw new BadRequestException("Invalid Request");
        }

        UserRfid ur = userRfidService.findById(userRfid.getUserRfidId());

        ur.setActive(userRfid.getActive());

        ur.getRfid().setTag0(userRfid.getRfid().getTag0());
        ur.getRfid().setTag1(userRfid.getRfid().getTag1());
        ur.getRfid().setTag2(userRfid.getRfid().getTag2());
        ur.getRfid().setTag3(userRfid.getRfid().getTag3());
        ur.getRfid().setPin(userRfid.getRfid().getPin());

        return gson.toJson(userRfidService.save(ur));
    }
}
