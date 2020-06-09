package com.lkc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lkc.model.FangAn;
import com.lkc.model.OrderDetailEntity;
import com.lkc.service.ShuService;
import com.lkc.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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

    //跳到购物页面
    @RequestMapping("/GouWu")
    public String gouwu(){
        return "GouWu";
    }
    //购物页面跳购物页面
    @RequestMapping("/GouWuChe")
    public String GouWuChe(){
        return "GouWu";
    }
    //跳到第一次结算页
    @RequestMapping("/DiYiXia")
    public String DiYiXia(){
        return "DiYiXia";
    }
    //购物详情页面
    @RequestMapping("/GouWuXiangQing")
    public String GouWuXiangQing(){
        return "GouWuXiangQing";
    }
    //ai币商城
    @RequestMapping("/AIBi")
    public String AIBi(){
        return "AIBi";
    }
    //购物页面
    @RequestMapping("/GouWuc")
    public String GouWuc(){
        return "GouWu";
    }

    //跳转到上传页面
    @RequestMapping("/ShangChuan")
    public String ShangChuan(){
        return "FangAnShangChuan";
    }

    //回显图片  lubotu
    @RequestMapping("upload")
    @ResponseBody
    private Map upload(MultipartFile file, HttpServletRequest request){
        HashMap<String, Object> hashMap = new HashMap<>();
        String fileUpload = FileUtil.FileUpload(file, request);
        hashMap.put("img", fileUpload);
        return hashMap;
    }

    @RequestMapping("/addShang")
    @ResponseBody
    public void addShang(FangAn fangAn){
        shuService.addShang(fangAn);

    }




}
