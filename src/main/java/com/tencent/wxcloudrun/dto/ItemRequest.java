package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class ItemRequest {
    private String type;
    private int offset;
    private int count;
}
