package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// name rules: table_name+Mapper
@Mapper
public interface UserMapper extends BaseMapper<User> {
// without using mybatisplus
//    // find all users
//    @Select("select * from user")
//    public List<User> findAll();
//
//    @Insert("insert into user values(#{id}, #{username}, #{password}, #{birthday})")
//    // @Insert("insert into user (id, username, password, birthday)")
//    public int insert(User user);
//
//    @Update("update user set username=#{username}, password=#{password}, birthday=#{birthday} where id=#{id}")
//    public int update(User user);
//
//    @Delete("delete from user where id=#{id}")
//    public int delete(int id);
//
//    @Select("select * from user where id=#{id}")
//    public List<User> findById(int id);
}
