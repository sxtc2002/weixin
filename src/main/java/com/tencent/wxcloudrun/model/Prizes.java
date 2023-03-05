package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Prizes implements Serializable {
    private int grade;
    private int num;
    public void decNum() {
        this.num--;
    }
}
