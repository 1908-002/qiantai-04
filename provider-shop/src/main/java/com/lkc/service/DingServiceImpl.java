package com.lkc.service;

import com.lkc.Repository.EsRepository;
import com.lkc.mapper.DingMapper;
import com.lkc.model.OrderDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DingServiceImpl implements DingService {

    @Autowired
    private DingMapper dingMapper;

    @Resource
    private EsRepository esRepository;


    @RequestMapping("selectQbDD")
    @Override
    public Map<String, Object> selectQbDD(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = dingMapper.getcount();
        List<OrderDetailEntity> list = dingMapper.selectQbDD((page-1)*rows,rows);
        for (OrderDetailEntity order: list) {
            OrderDetailEntity entity = new OrderDetailEntity();
            entity.setId(order.getId());
            entity.setOrder_id(order.getOrder_id());
            entity.setUser_id(order.getUser_id());
            entity.setSku_id(order.getSku_id());
            entity.setSku_name(order.getSku_name());
            entity.setOrder_price(order.getOrder_price());
            entity.setSku_num(order.getSku_num());
            entity.setCreate_time(order.getCreate_time());
            entity.setOrderstatus(order.getOrderstatus());
            entity.setMiaosu(order.getMiaosu());
            entity.setImgpath(order.getImgpath());
            entity.setShifukuan(order.getShifukuan());
            entity.setShangPinType(order.getShangPinType());
            esRepository.save(entity);
        }

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @RequestMapping("/delDD")
    @Override
    public void delDD(@RequestParam Integer id) {
        dingMapper.delDD(id);
    }

    @RequestMapping("/delAll")
    @Override
    public void delAll(@RequestParam String ids) {
        dingMapper.delAll(ids);
    }

    @RequestMapping("/selecthsz")
    @Override
    public Map<String, Object> selecthsz(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows) {
            Integer total = dingMapper.getcountHSZ();
            List<OrderDetailEntity> list = dingMapper.selecthsz((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @RequestMapping("/selectdfk")
    @Override
    public Map<String, Object> selectdfk(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = dingMapper.getcountdfk();
        List<OrderDetailEntity> list = dingMapper.selectdfk((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @RequestMapping("/selectdfh")
    @Override
    public Map<String, Object> selectdfh(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = dingMapper.getcountdfh();
        List<OrderDetailEntity> list = dingMapper.selectdfh((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @RequestMapping("/selectdsh")
    @Override
    public Map<String, Object> selectdsh(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = dingMapper.getcountdsh();
        List<OrderDetailEntity> list = dingMapper.selectdsh((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @RequestMapping("/selectdpj")
    @Override
    public Map<String, Object> selectdpj(@RequestParam Integer page,@RequestParam Integer rows) {
        Integer total = dingMapper.getcountdpj();
        List<OrderDetailEntity> list = dingMapper.selectdpj((page-1)*rows,rows);

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }
}
