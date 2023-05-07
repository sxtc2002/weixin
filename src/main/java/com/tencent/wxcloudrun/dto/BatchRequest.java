package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class BatchRequest {
    private String type;
    private int offset;
    private int count;
}
