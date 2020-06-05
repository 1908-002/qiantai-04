package com.lkc.controller;


import com.lkc.model.ItemEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GouWuCheController {




    @RequestMapping("/toGoWuChe")
    public String toGoWuChe(){
        return "gouwuche";
    }


    @RequestMapping("/savaGouwu")
    public void savaGouwu(Integer id){



    }


}
