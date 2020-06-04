package com.lkc.controller;

import com.lkc.service.DingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class DingController {
    @Resource
    private DingService dingService;

    @RequestMapping("/toDingDan")
    public String toDingDan(){
        return "DingDan";
    }

    @RequestMapping("/selectQbDD")
    @ResponseBody
    public Map<String,Object> selectQbDD(Integer page, Integer rows) {


        return dingService.selectQbDD(page, rows);
    }

    @RequestMapping("/delDD")
    @ResponseBody
    public void delDD(Integer id){
        dingService.delDD(id);
    }
}
