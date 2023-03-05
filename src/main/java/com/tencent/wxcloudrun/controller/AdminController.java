package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @GetMapping(value = "/api/admin")
    ApiResponse get(@RequestHeader("x-wx-openid") String id) {
        return ApiResponse.ok(verify(id));
    }

}
