package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Prizes;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PrizesMapper {
    ArrayList<Prizes> viewPrize();
}
