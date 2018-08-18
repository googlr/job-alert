package com.myjobalert.demo;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="User")
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

    @DynamoDBHashKey(attributeName="userId")
    public String getUserId(){
        return userId;
    }

    @DynamoDBAttribute(attributeName="userName")
    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
        //update the database
    }

    @DynamoDBAttribute(attributeName="userEmail")
    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String userEmail){
        //validate newEmailAddress;
        // to-do

        this.userEmail = userEmail;
        //update the database
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "User {" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

}