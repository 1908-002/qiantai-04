package com.lkc.controller;

import com.lkc.model.FangAn;
import com.lkc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import com.lkc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2(){
        return helloService.hello2();
    }

    @RequestMapping("/dingDan")
    public String mian(){

        return "tree";
    }
    //跳转到首页
    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    //跳转到方案馆
    @RequestMapping("/toFangAnGuAn")
    @ResponseBody
    public ModelAndView toFangAnGuAn(){
        List<FangAn> fangan = helloService.selectFangAnGuAn();
        ModelAndView mav = new ModelAndView();
        mav.addObject("fangan",fangan);
        mav.setViewName("FangAnGuAn");
        return mav;
    }


    //查询数据库表里的数据并分页
    @GetMapping("/selectList")
    @ResponseBody
    public Map<String,Object> selectList(Integer page, Integer rows){
        return helloService.selectList(page,rows);
    }


    //查询数据并跳转到详情页面
    @RequestMapping("/selectXQ")
    public ModelAndView selectXQ(Integer id) {
        FangAn ids = helloService.selectXiang(id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("ids",ids);
        mav.setViewName("XiangQing");
        return mav;
    }

        @RequestMapping("/tree")
        @ResponseBody
        public ModelAndView tree () {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("userList");
            return mav;
        }


        @RequestMapping("/selectTree")
        @ResponseBody
        public List<Tree> selectTree () {

            return helloService.selectTree();
        }

        @RequestMapping("/userList")
        @ResponseBody
        public ModelAndView userList () {

            List<UserEntity> userList = helloService.select();
            ModelAndView mav = new ModelAndView();
            mav.setViewName("userList");
            mav.addObject("userList", userList);

            return mav;


        }



}
