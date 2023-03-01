package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private String id;
    private boolean join;
    private int hit;
    private String nick;
    private String tel;
    private LocalDateTime createdAt;
}
