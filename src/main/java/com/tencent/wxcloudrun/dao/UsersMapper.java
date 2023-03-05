package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UsersMapper {
    User getUser(@Param("id") String id);
    void insertUser(@Param("id") String id);
    void updateUser(@Param("id") String id, @Param("nick") String nick, @Param("tel") String tel);
    void awardUser(@Param("id") String id, @Param("hit") int hit);
    void clearUser();
    ArrayList<User> viewUser();
}
