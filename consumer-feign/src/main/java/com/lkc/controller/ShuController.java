package com.lkc.controller;

import com.lkc.model.OrderDetailEntity;
import com.lkc.service.ShuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShuController {
    @Resource
    private ShuService shuService;

    @RequestMapping("/shang")
    @ResponseBody
    public ModelAndView shang(){
        OrderDetailEntity order = shuService.selectOrder();

        ModelAndView mav = new ModelAndView();
        mav.addObject("order",order);
        mav.setViewName("shang");
        return mav;
    }

    @RequestMapping("/GouWu")
    public String gouwu(){
        return "GouWu";
    }
    @RequestMapping("/GouWuChe")
    public String GouWuChe(){
        return "GouWu";
    }
    @RequestMapping("/DiYiXia")
    public String DiYiXia(){
        return "DiYiXia";
    }
    @RequestMapping("/GouWuXiangQing")
    public String GouWuXiangQing(){
        return "GouWuXiangQing";
    }
    @RequestMapping("/AIBi")
    public String AIBi(){
        return "AIBi";
    }
    @RequestMapping("/GouWuc")
    public String GouWuc(){
        return "GouWu";
    }
}
