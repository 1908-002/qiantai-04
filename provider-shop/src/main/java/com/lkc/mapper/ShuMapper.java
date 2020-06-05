package com.lkc.mapper;

import com.lkc.model.OrderDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface ShuMapper {
    @Select("select * from order_detail where id=3 ")
    OrderDetailEntity selectOrder();
}
