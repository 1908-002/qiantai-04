package com.lkc.service;

import com.lkc.mapper.DingMapper;
import com.lkc.model.OrderDetailEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DingServiceImpl implements DingService {

    @Resource
    private DingMapper dingMapper;

    @Override
    @RequestMapping("selectQbDD")
    public Map<String, Object> selectQbDD(Integer page, Integer rows) {
        Integer total = dingMapper.getcount();
        List<OrderDetailEntity> list = dingMapper.selectQbDD((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    @RequestMapping("/delDD")
    public void delDD(Integer id) {
        dingMapper.delDD(id);
    }

    @Override
    @RequestMapping("/delAll")
    public void delAll(String ids) {
        dingMapper.delAll(ids);
    }
}
