package com.lkc.controller;

import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import com.lkc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/")
    public String mian(){

        return "tree";
    }


    @RequestMapping("/tree")
    @ResponseBody
    public ModelAndView tree(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userList");
        return mav;
    }


    @RequestMapping("/selectTree")
    @ResponseBody
    public List<Tree> selectTree(){

        return helloService.selectTree();
    }

    @RequestMapping("/userList")
    @ResponseBody
    public ModelAndView userList(){

        List<UserEntity> userList = helloService.select();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userList");
        mav.addObject("userList",userList);

        return mav;


    }


}
