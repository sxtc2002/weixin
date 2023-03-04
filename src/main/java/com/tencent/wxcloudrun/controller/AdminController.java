package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminController {
    final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    private boolean verify(String id) {
        ArrayList<Admin> admins = adminService.viewAdmin();
        for(Admin admin: admins) {
            if(id.equals(admin.getId()))
                return true;
        }
        return false;
    }

}
