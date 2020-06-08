package com.lkc.controller;


import com.lkc.model.GouWu;
import com.lkc.model.OrderDetailEntity;
import com.lkc.service.GouWuCheService;
import com.lkc.utils.RedisContant;
import com.lkc.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GouWuCheController {

    @Resource
    private GouWuCheService gouWuCheService;

    @Autowired
    private RedisUtil redisUtil;


    //加入购物车
    @RequestMapping("/savaGouWu")
    public void savaGouwu(Integer id) {

        //删除Redis
        redisUtil.del(RedisContant.SELECT_GOUWU);
        //查询数据商品

        OrderDetailEntity o = gouWuCheService.getItem(id);

    }

    //我的购物车
    @RequestMapping("/GouWu")
    @ResponseBody
    public ModelAndView selectGouWu(){

        ModelAndView mav = new ModelAndView();

        List<GouWu> gouWuList = (List) redisUtil.get(RedisContant.SELECT_GOUWU);
        if(gouWuList == null){
           gouWuList = gouWuCheService.selectGouWu();
            redisUtil.set(RedisContant.SELECT_GOUWU,gouWuList);
        }

        mav.setViewName("gouwuche");
        mav.addObject("gouWuList",gouWuList);
        return mav;
    }

    //删除购物车商品
    @RequestMapping(value = "/delectGwcById",method = RequestMethod.POST)
    @ResponseBody
    public String delectGwcById(Integer id){
        //删除Redis
        redisUtil.del(RedisContant.SELECT_GOUWU);
        gouWuCheService.delectGwcById(id);
        return "删除成功";
    }


    //清空购物车
    @RequestMapping("/delAllGouWu")
    @ResponseBody
    public ModelAndView delAllGouWu(){

        ModelAndView mav = new ModelAndView();
        //删除Redis
        redisUtil.del(RedisContant.SELECT_GOUWU);
       gouWuCheService.delAllGouWu();
        mav.setViewName("gouwuche");

        return mav;
    }

}
