package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.mybatis.anotation.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from mybatis")
    List<User> findAll();
}
