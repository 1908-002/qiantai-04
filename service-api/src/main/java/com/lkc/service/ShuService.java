package com.lkc.service;

import com.lkc.model.FangAn;
import com.lkc.model.OrderDetailEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("provider-shop")
public interface ShuService {

    @GetMapping("/shang")
    OrderDetailEntity selectOrder();

    @PostMapping("/addShang")
    void addShang(@RequestBody FangAn fangAn);
}
