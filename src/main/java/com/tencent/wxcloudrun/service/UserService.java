package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String id);
    void insertUser(User user);
    void updateUser(User user);
    ArrayList<User> viewUser();
}
