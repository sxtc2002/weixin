package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Item;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ItemController {

    @GetMapping(value = "/api/item")
    ApiResponse item() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("type", "news");
        paramMap.add("offset", "0");
        paramMap.add("count", "20");
        String item = restTemplate.postForObject("https://api.weixin.qq.com/cgi-bin/material/batchget_material"
                , paramMap, String.class);
        return ApiResponse.ok(item);
    }
}
