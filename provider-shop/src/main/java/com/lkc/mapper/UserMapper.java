package com.lkc.mapper;

import com.lkc.model.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Select("select * from user_1 where userCode=#{userName}")
    UserEntity selectUserByCode(String userName);

    @Insert("insert into user_1(userCode,\n" +
            "userName,\n" +
            "password,\n" +
            "salt,\n" +
            "locked,iphone) values (#{userCode},#{userName},#{password},#{salt},#{locked},#{iphone})")
    void addUser(UserEntity user);


    @Select("select userId as userId,userCode as userName,password ,salt,locked,iphone from user_1 where iphone = #{iphone}")
    UserEntity queryUserByPhone(UserEntity user);
}
