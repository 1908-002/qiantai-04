package com.lkc.controller;

import com.lkc.model.FangAn;
import com.lkc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import com.lkc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/")
    public String mian(){

        return "tree";
    }
    //跳转到首页
    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toFangAnGuAn")
    public String toFangAnGuAn(){
        return "FangAnGuAn";
    }

    @GetMapping("/selectList")
    @ResponseBody
    public Map<String,Object> selectList(Integer page, Integer rows){
        return helloService.selectList(page,rows);
    }

    @PostMapping("/selectInfo")
    @ResponseBody
    public void selectInfo(Integer id){
        helloService.selectInfo(id);

    }

    @PostMapping("/updateXia")
    @ResponseBody
    public void updateXia(Integer id){
        helloService.updateXia(id);

    }

    @RequestMapping("/selectXQ")
    @ResponseBody
    public ModelAndView selectXQ(Integer id) {


        FangAn fangan = helloService.selectShuJu(id);


        ModelAndView mav = new ModelAndView();
        mav.addObject("fangan", fangan);
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
