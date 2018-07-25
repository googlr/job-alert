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

    public void setUserName(String newUserName){
        this.userName = newUserName;
        //update the database
    }

    public void setEmailAddress(String newEmailAddress){
        //validate newEmailAddress;
        // to-do
        //

        this.emailAddress = newEmailAddress;
        //update the database
    }

}