package com.itheima.mybatis.sqlsession;

import com.itheima.mybatis.cfg.Configuration;

public interface SqlSessionFactory {

    SqlSession openSession();
}
