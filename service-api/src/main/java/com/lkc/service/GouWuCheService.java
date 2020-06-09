package com.lkc.service;

import com.lkc.model.GouWu;
import com.lkc.model.OrderDetailEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("provider-shop")
public interface GouWuCheService {

    @RequestMapping("/savaGouwu")
    OrderDetailEntity getItem(@RequestParam Integer id);


    @RequestMapping("/selectGouWu")
    List<GouWu> selectGouWu();

    @PostMapping("/delectGwcById")
    void delectGwcById( @RequestParam Integer id);

    @RequestMapping("/delAllGouWu")
    void delAllGouWu();
}
