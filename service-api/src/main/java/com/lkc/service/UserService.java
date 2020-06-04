package com.lkc.service;

import com.lkc.model.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider-shop")
public interface UserService {

    @GetMapping("/selectUserByCode")
    UserEntity selectUserByCode(@RequestParam String userName);

    @PostMapping("/iphoneLogin")
    UserEntity queryUserByPhone(UserEntity user);

    @PostMapping("/addUser")
    UserEntity addUser(UserEntity user);


}
