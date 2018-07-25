package com.job-alert.domain;

public class User {
    private String userId;
    private String userName;
    private String emailAddress;


    User(String userId, String userName, String emailAddress) {
        this.userId = userId;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

}