package com.itheima.mybatis.sqlsession;

import com.itheima.mybatis.Utils.XMLConfigBuilder;
import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlsession.impl.DefaultSqlSessionFactory;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream config){
        /**
         * 解析InputStream生成Configuration对象
         * 创建SqlSessionFactory对象
         */

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);
    }
}
