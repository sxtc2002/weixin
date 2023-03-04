package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.AdminsMapper;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {
    final AdminsMapper adminsMapper;

    public AdminServiceImpl(@Autowired AdminsMapper adminsMapper) {
        this.adminsMapper = adminsMapper;
    }

    @Override
    public ArrayList<Admin> viewAdmin() {
        return adminsMapper.viewAdmin();
    }
}
