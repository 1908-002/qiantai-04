package com.lkc.controller;

import com.lkc.service.DingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/delAll")
    @ResponseBody
    public void delAll(String ids){
        dingService.delAll(ids);
    }

    @RequestMapping("/toHuiShou")
    public String toHuiShou(){
        return "huishou";
    }

    @RequestMapping("/selecthsz")
    @ResponseBody
    public Map<String,Object> selecthsz(Integer page, Integer rows) {


        return dingService.selecthsz(page, rows);
    }
}
