package com.lkc.service;

import com.lkc.mapper.ShuMapper;
import com.lkc.model.FangAn;
import com.lkc.model.OrderDetailEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShuServiceImpl implements ShuService{
    @Resource
    private ShuMapper shuMapper;

    @RequestMapping("/shang")
    @Override
    public OrderDetailEntity selectOrder() {
        return shuMapper.selectOrder();
    }

        @RequestMapping("/addShang")
        @Override
        public void addShang(@RequestBody FangAn fangAn) {
            if(fangAn.getAiBi()==0){
                //免费
                fangAn.setFlAs("免费");
            }else{
                //收费
                fangAn.setFlAs("收费");
            }
            shuMapper.addShang(fangAn);
        }
}
