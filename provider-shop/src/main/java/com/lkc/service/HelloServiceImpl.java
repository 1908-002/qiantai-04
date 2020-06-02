package com.lkc.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceImpl implements HelloService{

    @RequestMapping("/hi2")
    @Override
    public String hello2() {
        return "调用成功2";
    }
}
