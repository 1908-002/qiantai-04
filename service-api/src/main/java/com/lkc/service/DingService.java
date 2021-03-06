package com.lkc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("provider-shop")
public interface DingService {
    @RequestMapping("selectQbDD")
    Map<String,Object> selectQbDD(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/delDD")
    void delDD(@RequestParam("id")Integer id);

    @RequestMapping("/delAll")
    void delAll(@RequestParam("ids")  String ids);

    @RequestMapping("/selecthsz")
    Map<String, Object> selecthsz(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/selectdfk")
    Map<String, Object> selectdfk(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/selectdfh")
    Map<String, Object> selectdfh(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/selectdsh")
    Map<String, Object> selectdsh(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);

    @RequestMapping("/selectdpj")
    Map<String, Object> selectdpj(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows);
}
