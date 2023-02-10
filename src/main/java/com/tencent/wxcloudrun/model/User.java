package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    private String id;
    private Boolean qualification;
    private LocalDateTime createdAt;
}
