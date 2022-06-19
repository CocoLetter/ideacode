package com.itheima.mybatis.Utils;

import com.itheima.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatasourceUtils {
    public static Connection getConnection(Configuration cfg){

        try {
            Class.forName(cfg.getDriver());//加载类
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);

        }


    }
}
