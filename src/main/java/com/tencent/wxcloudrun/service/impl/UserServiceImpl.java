package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.UsersMapper;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    final UsersMapper usersMapper;

    public UserServiceImpl(@Autowired UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Optional<User> getUser(String id) {
        return Optional.ofNullable(usersMapper.getUser(id));
    }

    @Override
    public void insertUser(User user) {
        usersMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        usersMapper.updateUser(user);
    }

    @Override
    public ArrayList<User> viewUser() {
        return usersMapper.viewUser();
    }
}
