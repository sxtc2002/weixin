package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.model.Prizes;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.PrizeService;
import com.tencent.wxcloudrun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class AdminController {
    final AdminService adminService;
    final PrizeService prizeService;
    final UserService userService;
    final Logger logger;

    public AdminController(@Autowired AdminService adminService, PrizeService prizeService, UserService userService) {
        this.adminService = adminService;
        this.prizeService = prizeService;
        this.userService = userService;
        this.logger = LoggerFactory.getLogger(UserController.class);
    }

    private boolean verify(String id) {
        ArrayList<Admin> admins = adminService.viewAdmin();
        for (Admin admin: admins) {
            if(id.equals(admin.getId()))
                return true;
        }
        return false;
    }

    @GetMapping(value = "/admin")
    ApiResponse get(@RequestHeader("x-wx-openid") String id) {
        return ApiResponse.ok(verify(id));
    }

    @PostMapping(value = "/admin/draw")
    ApiResponse draw(@RequestHeader("x-wx-openid") String id) {
        logger.info("/api/draw post request");
        if(!verify(id)) {
            return ApiResponse.error("没有权限");
        }
        userService.clearUser();
        ArrayList<Prizes> prizes = prizeService.viewPrize();
        ArrayList<User> users = userService.viewUser();
        Random random = new Random();
        int num = 0, len = users.size();
        boolean[] b = new boolean[len];
        for (Prizes prize: prizes) {
            num += prize.getNum();
        }
        for(int i = 0, j = 0; i < num; ++i) {
            int x = random.nextInt(len);
            while(b[x]) x = random.nextInt(len);
            b[x] = true;
            userService.awardUser(users.get(x).getId(), prizes.get(j).getGrade());
            prizes.get(j).decNum();
            if(prizes.get(j).getNum() == 0)
                j++;
        }
        return ApiResponse.ok();
    }
    @GetMapping(value = "/admin/draw/view")
    ApiResponse viewWinners(@RequestHeader("x-wx-openid") String id) {
        logger.info("/api/draw/view get request");
        if(!verify(id)) {
            return ApiResponse.error("没有权限");
        }
        ArrayList<User> users = userService.selectUser();
        return ApiResponse.ok(users);
    }
}
