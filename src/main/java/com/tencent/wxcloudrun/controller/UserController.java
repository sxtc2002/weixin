package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.UserRequest;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.PrizeService;
import com.tencent.wxcloudrun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
public class UserController {
    final UserService userService;
    final PrizeService prizeService;
    final Logger logger;

    public UserController(@Autowired UserService userService, PrizeService prizeService) {
        this.userService = userService;
        this.prizeService = prizeService;
        this.logger = LoggerFactory.getLogger(UserController.class);
    }
    @GetMapping(value = "/api/user")
    ApiResponse get(@RequestHeader("x-wx-openid") String id) {
        logger.info("/api/user get request");
        Optional<User> user = userService.getUser(id);
        if(user.isPresent()) {
            return ApiResponse.ok(user);
        } else {
            return ApiResponse.error("用户id不存在");
        }
    }

    @PostMapping(value = "/api/user")
    ApiResponse post(@RequestHeader("x-wx-openid") String id, @RequestBody UserRequest request) {
        logger.info("/api/user post request, action: {}, id: {}", request.getAction(), id);
        if(request.getAction().equals("insert")) {
            Optional<User> user = userService.getUser(id);
            if(user.isPresent()) {
                return ApiResponse.error("用户已存在");
            } else {
                userService.insertUser(id);
                return ApiResponse.ok(0);
            }
        } else if(request.getAction().equals("update")) {
            userService.updateUser(id, request.getNick(), request.getTel());
            return ApiResponse.ok(0);
        } else {
            return ApiResponse.error("参数action错误");
        }
    }
    @GetMapping(value = "/api/draw/view")
    ApiResponse viewWinners(@RequestHeader("x-wx-openid") String id) {
        logger.info("/api/draw/view get request, id: {}", id);
        ArrayList<User> users = userService.selectUser();
        for (User user: users) {
            char[] nick = user.getNick().toCharArray();
            for(int i = 1; i < nick.length; ++i)
                nick[i] = '*';
            user.setNick(new String(nick));
            char[] tel = user.getTel().toCharArray();
            for(int i = 0; i < tel.length - 4; ++i)
                tel[i] = '*';
            user.setTel(new String(tel));
        }
        return ApiResponse.ok(users);
    }
    @GetMapping(value = "/api/view")
    ApiResponse view() {
        ArrayList<User> users = userService.viewUser();
        return ApiResponse.ok(users);
    }
    @GetMapping(value = "/api/ifdraw")
    ApiResponse viewIfdraw() {
        logger.info("/api/ifdraw get request");
        return ApiResponse.ok(prizeService.viewIfdraw());
    }
}
