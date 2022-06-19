package com.itheima.mybatis.sqlsession.impl;

import com.itheima.mybatis.Utils.DatasourceUtils;
import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlsession.Proxy.MapperProxy;
import com.itheima.mybatis.sqlsession.SqlSession;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;
    public DefaultSqlSession(Configuration cfg ){
        this.cfg=cfg;
        this.conn= DatasourceUtils.getConnection(cfg);
    }

    /*
    * 用于创建代理对象*/
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)  Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));

        /**
         * 这里直接使用接口类daoInterfaceClass作为newProxyInstance函数第一个参数
         */

    }

    /*
    * 用于释放资源*/
    @Override
    public void close() {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
