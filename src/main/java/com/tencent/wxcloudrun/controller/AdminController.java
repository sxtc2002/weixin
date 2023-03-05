package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.model.Prize;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.PrizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AdminController {
    final AdminService adminService;
    final PrizeService prizeService;

    public AdminController(AdminService adminService, PrizeService prizeService) {
        this.adminService = adminService;
        this.prizeService = prizeService;
    }

    private boolean verify(String id) {
        ArrayList<Admin> admins = adminService.viewAdmin();
        for (Admin admin: admins) {
            if(id.equals(admin.getId()))
                return true;
        }
        return false;
    }

    @GetMapping(value = "/api/admin")
    ApiResponse get(@RequestHeader("x-wx-openid") String id) {
        return ApiResponse.ok(verify(id));
    }

    @PostMapping(value = "/api/draw")
    ApiResponse draw(@RequestHeader("x-wx-openid") String id) {
        if(!verify(id)) {
            return ApiResponse.error("没有权限");
        }
        ArrayList<Prize> prizes = prizeService.viewPrize();

        return ApiResponse.ok(prizes);
    }
}
