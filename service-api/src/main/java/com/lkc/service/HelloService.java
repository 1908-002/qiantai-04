package com.lkc.service;

import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("provider-shop")
public interface HelloService {

    @RequestMapping("/hi2")
    String hello2();


    @GetMapping("/select")
    List<UserEntity> select();


    @RequestMapping("/selectTree")
    List<Tree> selectTree();


}
