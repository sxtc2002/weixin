package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UsersMapper {
    User getUser(@Param("id") String id);
    void insertUser(User user);
    void updateUser(User user);

    ArrayList<User> viewUser();
}
