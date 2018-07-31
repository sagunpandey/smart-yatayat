package com.sagunpandey.smartyatayat.entities;

import javax.persistence.*;

@Entity
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfo userInfo;

    @Column(nullable = false)
    private Integer transactionType;

    @Column(nullable = false)
    private Integer transactedAmount;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getTransactedAmount() {
        return transactedAmount;
    }

    public void setTransactedAmount(Integer transactedAmount) {
        this.transactedAmount = transactedAmount;
    }
}

