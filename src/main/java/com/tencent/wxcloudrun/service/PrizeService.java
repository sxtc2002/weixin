package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Prizes;

import java.util.ArrayList;

public interface PrizeService {
    ArrayList<Prizes> viewPrize();
    void changeIfdraw(int ifdraw);
    boolean viewIfdraw();
}
