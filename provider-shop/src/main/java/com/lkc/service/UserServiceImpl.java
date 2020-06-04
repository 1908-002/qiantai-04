package com.lkc.service;

import com.lkc.mapper.UserMapper;
import com.lkc.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

@RestController
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/selectUserByCode")
    @Override
    public UserEntity selectUserByCode(@RequestParam String userName) {
        return userMapper.selectUserByCode(userName);
    }

    @PostMapping("/iphoneLogin")
    @Override
    public UserEntity queryUserByPhone(@RequestBody UserEntity user) {
        return userMapper.queryUserByPhone(user);
    }

    @PostMapping("/addUser")
    @Override
    public UserEntity addUser(@RequestBody UserEntity user) {
        user.setSalt(user.getUserCode());
        String hashAlgorithmName = "MD5";//加密方式 MD5  SHA
        Object crdentials = user.getPassword();//密码原值
        Object salt = user.getSalt();//盐值 (用户账号、UUID、时间戳、随机字母 作为盐值，盐值必须保持唯一)
        ByteSource saltByte = ByteSource.Util.bytes(salt);
        int hashIterations = 2;//加密1024次  散列次数
        Object result = new SimpleHash(hashAlgorithmName,crdentials,saltByte,hashIterations);
        user.setPassword(result.toString());
        user.setLocked("2");
        userMapper.addUser(user);
        return user;
    }

}
