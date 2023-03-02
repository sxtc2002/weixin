package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String action;
    private boolean join;
    private String nick;
    private String tel;
}
