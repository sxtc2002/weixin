package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String id);
    void insertUser(String id);
    void updateUser(String id, String nick, String tel);
    void awardUser(String id, int hit);
    void clearUser();
    ArrayList<User> selectUser();
    ArrayList<User> viewUser();
}
