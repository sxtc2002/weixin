package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminsMapper {
    ArrayList<Admin> viewAdmin();
}
