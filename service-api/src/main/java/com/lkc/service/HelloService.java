package com.lkc.service;

import com.lkc.model.FangAn;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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

    @GetMapping("/selectList")
    Map<String, Object> selectList(@RequestParam Integer page,@RequestParam Integer rows);

    @PostMapping("/selectInfo")
    void selectInfo(@RequestParam Integer id);

    @PostMapping("/updateXia")
    void updateXia(@RequestParam Integer id);

    @GetMapping("/selectXQ")
    FangAn selectShuJu(@RequestParam Integer id);

    @GetMapping("/select")
    List<UserEntity> select();


    @GetMapping("/selectTree")
    List<Tree> selectTree();


}
