package com.lkc.controller;

import com.alibaba.fastjson.JSON;
import com.lkc.model.UserEntity;
import com.lkc.service.UserService;
import com.lkc.utils.CheckSumBuilder;
import com.lkc.utils.HttpClientUtil;
import com.lkc.utils.MessageConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.IncompleteAnnotationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //shiro登录验证
    @PostMapping("/login")
    @ResponseBody
    public String login(UserEntity user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken upt=new UsernamePasswordToken(user.getUserCode(),user.getPassword());

        try {
            subject.login(upt);
            return "登录成功";
        }catch (UnknownAccountException uae){
            return "账号不存在";
        }catch (IncompleteAnnotationException ice){
            return "密码错误";
        }catch (AuthenticationException e){
            return "登录失败";
        }

    }

    //手机号验证
    @RequestMapping(value="/iphoneLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> iphoneLogin(UserEntity user, HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();

        UserEntity dbUser = userService.queryUserByPhone(user);
        if(dbUser != null) {
            // 验证短信验证码

            HashMap<String, Object> params = new HashMap<>();
            params.put("mobile", user.getIphone());
            params.put("code", user.getCode());

            String nonceNum = String.valueOf(Math.round(Math.ceil(Math.random() * 100000 + 899999)));
            String timeMil = String.valueOf((new Date()).getTime() / 1000L);
            HashMap<String, Object> headerParam = new HashMap<>();
            headerParam.put("Content-Type", MessageConstant.CONTENT_TYPE);
            headerParam.put("AppKey", MessageConstant.APP_KEY);
            headerParam.put("Nonce", nonceNum);
            headerParam.put("CurTime", timeMil);
            headerParam.put("CheckSum", CheckSumBuilder.getCheckSum(MessageConstant.APP_SECRET, nonceNum, timeMil));
            String resultJson = HttpClientUtil.post3(MessageConstant.VERIFY_URL, params, headerParam);
            Map<String, Integer> resultMap = JSON.parseObject(resultJson, Map.class);
            Integer resultCode = resultMap.get("code");
            if(resultCode != null && 200 == resultCode) {
                request.getSession().setAttribute("user", dbUser);
                map.put("statusCode", "200");
                map.put("message", "登录成功");
            } else {
                map.put("statusCode", "1002");
                map.put("message", "短信验证错误");
            }
        } else {
            map.put("statusCode", "1001");
            map.put("message", "该手机号未注册");
        }

        return map;

    }

    //发送手机验证码
    @PostMapping("/getPhoneCode")
    @ResponseBody
    public String getPhoneCode(String iphone){

        String nonceNum = String.valueOf(Math.round(Math.ceil(Math.random() * 100000 + 899999)));
        String timeMil = String.valueOf((new Date()).getTime() / 1000L);

        HashMap<String, Object> params = new HashMap<>();
        params.put("mobile", iphone);
        params.put("templateid", MessageConstant.TEMPLATEID);
        params.put("codeLen", MessageConstant.CODELEN);

        HashMap<String, Object> headerParam = new HashMap<>();
        headerParam.put("Content-Type", MessageConstant.CONTENT_TYPE);
        headerParam.put("AppKey", MessageConstant.APP_KEY);
        headerParam.put("Nonce", nonceNum);
        headerParam.put("CurTime", timeMil);
        headerParam.put("CheckSum", CheckSumBuilder.getCheckSum(MessageConstant.APP_SECRET, nonceNum, timeMil));


        String resultJson = HttpClientUtil.post3(MessageConstant.SERVER_URL, params, headerParam);
        System.out.println(resultJson);
        return resultJson;

    }

    //注册
    @PostMapping("/addUser")
    @ResponseBody
    public UserEntity add(UserEntity userEntity){
        return userService.addUser(userEntity);
    }

    //跳转登陆页面
    @GetMapping("/toLogin")
    public String toLogin(){
        return "index";
    }

    //跳转短信登陆页面
    @GetMapping("/toLoginList")
    public String toLoginList(){
        return "login";
    }

    //跳转主页面
    @GetMapping("/toMain")
    public String toMain(){
        return "main";
    }

    //跳转注册页面
    @GetMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

}
