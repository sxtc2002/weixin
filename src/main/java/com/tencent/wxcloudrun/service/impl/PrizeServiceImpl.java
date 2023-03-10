package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PrizesMapper;
import com.tencent.wxcloudrun.model.Prizes;
import com.tencent.wxcloudrun.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PrizeServiceImpl implements PrizeService {
    final PrizesMapper prizesMapper;

    public PrizeServiceImpl(@Autowired PrizesMapper prizesMapper) {
        this.prizesMapper = prizesMapper;
    }

    @Override
    public ArrayList<Prizes> viewPrize() {
        return prizesMapper.viewPrize();
    }

    @Override
    public void changeIfdraw(int ifdraw) {
        prizesMapper.changeIfdraw(ifdraw);
    }

    @Override
    public int viewIfdraw() {
        ArrayList<Prizes> ifdraw = prizesMapper.viewIfdraw();
        return ifdraw.get(0).getNum();
    }

}
