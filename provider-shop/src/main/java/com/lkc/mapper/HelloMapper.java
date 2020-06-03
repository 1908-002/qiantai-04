package com.lkc.mapper;

import com.lkc.model.Tree;
import com.lkc.model.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HelloMapper {

    @Select("select * from t_user_9 ")
    List<UserEntity> select();

    @Delete("delete from  t_user_9 where id = #{id}")
    void delete(Integer id);

    @Insert("insert into t_user_9 (username,name,password,phone,image,createtime) values(#{username},#{name},#{password},#{phone},#{image},now()) ")
    void addUser(UserEntity userEntity);

    @Select("select * from t_tree_9 where pid = #{id}")
    List<Tree> selectNodesById(Integer id);
}
