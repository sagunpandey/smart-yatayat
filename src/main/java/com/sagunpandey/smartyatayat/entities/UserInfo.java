package com.sagunpandey.smartyatayat.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sagunpandey.smartyatayat.helpers.Exclude;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserInfo {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInfoId;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    private Long phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer role = 2;

    @Column(nullable = false)
    private Integer balance = 0;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userInfo")
    private List<UserRfid> userRfids;

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<UserRfid> getUserRfids() {
        return userRfids;
    }

    public void setUserRfids(List<UserRfid> userRfids) {
        this.userRfids = userRfids;
    }
}
