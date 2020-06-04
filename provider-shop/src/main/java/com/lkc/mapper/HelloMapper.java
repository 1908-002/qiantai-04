package com.lkc.mapper;

import com.lkc.model.FangAn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HelloMapper {
    @Select("select count(1) from fangan ")
    Integer getcount();

    @Select("select * from fangan limit #{page},#{rows} ")
    List<FangAn> selectfangan(Integer page, Integer rows);

    @Update("update fangan set liulan = liuLan + 1 where id=#{id}")
    void selectInfo(Integer id);

    @Update("update fangan set xiazai = xiaZai + 1 where id=#{id}")
    void updateXia(Integer id);

    @Select("select * from fangan where id=#{id}")
    FangAn selectShuJu(Integer id);
}
