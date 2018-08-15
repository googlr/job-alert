package com.myjobalert.demo;

public class User {
    private String userId;
    private String userName;
    private String userEmail;

    public User(){}

    public User(String userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserId(){
        return userId;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
        //update the database
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String userEmail){
        //validate newEmailAddress;
        // to-do

        this.userEmail = userEmail;
        //update the database
    }

    @Override
    public String toString() {
        return "User {" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

}