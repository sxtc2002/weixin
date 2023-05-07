package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ItemRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItemController {

    @GetMapping(value = "/api/item")
    ApiResponse item() {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
        RestTemplate restTemplate = new RestTemplate();
        ItemRequest request = new ItemRequest();
        request.setType("news");
        request.setOffset(0);
        request.setCount(20);
        String item = restTemplate.postForObject(url, request, String.class);
        return ApiResponse.ok(item);
    }
}
