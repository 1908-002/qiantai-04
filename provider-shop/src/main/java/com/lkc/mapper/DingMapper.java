package com.lkc.mapper;

import com.lkc.model.OrderDetailEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DingMapper {

    @Select("<script>" +
            "select d1.id ,d1.order_id,d1.create_time ,d1.sku_num ,d1.orderstatus,\n" +
            " d1.sku_name ,d1.order_price ,i1.sku_desc as miaosu," +
            "(d1.sku_num*d1.order_price) as shifukuan, i1.imgpath as imgpath\n" +
            " from order_detail d1,item i1 where d1.sku_id = i1.id " +
            "and d1.orderstatus &lt; 5" +
            " limit #{page},#{rows}" +
            "</script>")
    List<OrderDetailEntity> selectQbDD(Integer page, Integer rows);


    @Delete("delete  from order_detail where id = #{id}")
    void delDD(Integer id);

    @Select("select count(1) from  order_detail d1,item i1 where d1.sku_id = i1.id and d1.orderstatus < 5 ")
    Integer getcount();
}
