package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ItemRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItemController {

    @GetMapping(value = "/api/item")
    ApiResponse item(@RequestBody ItemRequest itemRequest) {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material";
        RestTemplate restTemplate = new RestTemplate();
        String item = restTemplate.postForObject(url, itemRequest, String.class);
        return ApiResponse.ok(item);
    }
}
