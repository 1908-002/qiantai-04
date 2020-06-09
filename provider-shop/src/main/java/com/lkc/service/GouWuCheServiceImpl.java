package com.lkc.service;


import com.lkc.mapper.GouWuCheMapper;
import com.lkc.model.GouWu;
import com.lkc.model.OrderDetailEntity;

import com.lkc.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GouWuCheServiceImpl implements GouWuCheService {

    @Resource
    private GouWuCheMapper gouWuCheMapper;

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("/savaGouwu")
    public OrderDetailEntity getItem(Integer id) {
         OrderDetailEntity o = gouWuCheMapper.getItem(id);
        gouWuCheMapper.savaGouWu(o.getId());
      /* *//* if(String.valueOf(o.getId())!=null){
            redisUtil.set(String.valueOf(o.getId()),o);
        }*//*

        Map<String, Object> map = new HashMap<>();
        map.put(String.valueOf(o.getId()),o);
        redisUtil.hmset("savaGouwu",map);
        Map<Object, Object> map1 = redisUtil.hmget("savaGouwu");

        for (Object shu :map1.keySet() ){

        }*/
        return o;
    }

    @Override
    @RequestMapping("/selectGouWu")
    @ResponseBody
    public List<GouWu> selectGouWu() {
        return gouWuCheMapper.selectGouWu();
    }

    @Override
    @PostMapping("/delectGwcById")
    public void delectGwcById(@RequestParam("id") Integer id) {
        gouWuCheMapper.delectGwcById(id);
    }

    @Override
    @RequestMapping("/delAllGouWu")
    @ResponseBody
    public void delAllGouWu() {
        gouWuCheMapper.delAllGouWu();
    }
}
