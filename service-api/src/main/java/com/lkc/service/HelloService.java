package com.lkc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-shop")
public interface HelloService {

    @RequestMapping("/hi2")
    String hello2();
}
