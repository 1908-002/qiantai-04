package com.lkc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("provider-shop")
public interface DingService {
    @RequestMapping("selectQbDD")
    Map<String,Object> selectQbDD(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/delDD")
    void delDD(@RequestParam("id")Integer id);
}
