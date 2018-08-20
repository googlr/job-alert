package com.myjobalert.demo;

import java.util.List;

public interface UserServiceInterface {
    public List<User> getAllUsers();

    User addUser(String userId,
                 String userName,
                 String userEmail);

    User updateUser(User userToUpdate) throws Exception;

    boolean deleteUser(String id) throws Exception;

    User getUser(String id);
}