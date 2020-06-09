package com.lkc.controller;

import com.lkc.service.DingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class DingController {

    @Autowired
    private DingService dingService;

    @RequestMapping("/toDingDan")
    public String toDingDan(){
        return "DingDan";
    }

    @RequestMapping("/toDfk")
    public String toDfk(){
        return "dfk";
    }

    @RequestMapping("/toDfh")
    public String toDfh(){
        return "dfh";
    }

    @RequestMapping("/toDsh")
    public String toDsh(){
        return "dsh";
    }

    @RequestMapping("/toDpj")
    public String toDpj(){
        return "dpj";
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

    @RequestMapping("/selectdfk")
    @ResponseBody
    public Map<String,Object> selectdfk(Integer page, Integer rows) {


        return dingService.selectdfk(page, rows);
    }
    @RequestMapping("/selectdfh")
    @ResponseBody
    public Map<String,Object> selectdfh(Integer page, Integer rows) {


        return dingService.selectdfh(page, rows);
    }

    @RequestMapping("/selectdsh")
    @ResponseBody
    public Map<String,Object> selectdsh(Integer page, Integer rows) {


        return dingService.selectdsh(page, rows);
    }
    @RequestMapping("/selectdpj")
    @ResponseBody
    public Map<String,Object> selectdpj(Integer page, Integer rows) {


        return dingService.selectdpj(page, rows);
    }


}
