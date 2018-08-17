package com.myjobalert.demo;

import java.util.HashMap;

public interface UserServiceInterface {
    HashMap<Long,User> getAllUsers();

    User addUser(String userId,
                 String userName,
                 String userEmail);

    User updateUser(User userToUpdate) throws Exception;

    User deleteUser(long id) throws Exception;

    User getUser(long id);
}