package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.UserRequest;
import com.tencent.wxcloudrun.model.User;
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
    final Logger logger;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
        this.logger = LoggerFactory.getLogger(UserController.class);
    }
    @GetMapping(value = "/test")
    ApiResponse test(@RequestHeader("x-wx-openid") String id) {
        return ApiResponse.ok(id);
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
//            userService.updateUser(id);
            return ApiResponse.ok(request.isJoin());
        } else {
            return ApiResponse.error("参数action错误");
        }
    }
    @GetMapping(value = "/api/view")
    ApiResponse view() {
        ArrayList<User> users = userService.viewUser();
        return ApiResponse.ok(users);
    }
}
