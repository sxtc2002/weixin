package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.User;
import lombok.Data;

@Data
public class UserRequest {
    private String action;
    private User user;
}
