package com.lkc.mapper;

import com.lkc.model.GouWu;
import com.lkc.model.OrderDetailEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GouWuCheMapper {

    @Select("select * from order_detail where id = #{id}")
    OrderDetailEntity getItem(Integer id);

    @Insert("insert into gouwuche(sku_id,shuliang) values(#{id},1)")
    void savaGouWu(Integer id);

    @Select("select gouwuid,i.imgpath as img,i.price as price," +
            "i.sku_name as sku_name,shuliang,(i.price * g.shuliang) as xiaoji\n" +
            " from gouwuche g,item i where g.sku_id = i.id")
    List<GouWu> selectGouWu();

    @Delete("delete  from gouwuche where gouwuId = #{id} ")
    void delectGwcById(Integer id);

    @Delete("truncate gouwuche")
    void delAllGouWu();
}
