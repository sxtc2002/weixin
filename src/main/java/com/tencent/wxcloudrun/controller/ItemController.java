package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ItemRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItemController {

    final Logger logger;

    public ItemController() {
        this.logger = LoggerFactory.getLogger(ItemController.class);
    }

    @PostMapping(value = "/api/item")
    ApiResponse item(@RequestHeader("x-wx-openid") String id, @RequestBody ItemRequest itemRequest) {
        logger.info("/api/item get request, id: {}", id);
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
        RestTemplate restTemplate = new RestTemplate();
        String item = restTemplate.postForObject(url, itemRequest, String.class);
        return ApiResponse.ok(item);
    }
}
