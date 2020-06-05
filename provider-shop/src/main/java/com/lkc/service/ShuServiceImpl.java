package com.lkc.service;

import com.lkc.mapper.ShuMapper;
import com.lkc.model.OrderDetailEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShuServiceImpl implements ShuService{
    @Resource
    private ShuMapper shuMapper;

    @RequestMapping("/shang")
    @Override
    public OrderDetailEntity selectOrder() {
        return shuMapper.selectOrder();
    }
}
