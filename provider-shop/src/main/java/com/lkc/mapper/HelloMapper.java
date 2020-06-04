package com.lkc.mapper;

import com.lkc.model.FangAn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("select * from t_user_9 ")
    List<UserEntity> select();

    @Delete("delete from  t_user_9 where id = #{id}")
    void delete(Integer id);

    @Insert("insert into t_user_9 (username,name,password,phone,image,createtime) values(#{username},#{name},#{password},#{phone},#{image},now()) ")
    void addUser(UserEntity userEntity);

    @Select("select * from t_tree_9 where pid = #{id}")
    List<Tree> selectNodesById(Integer id);
}
