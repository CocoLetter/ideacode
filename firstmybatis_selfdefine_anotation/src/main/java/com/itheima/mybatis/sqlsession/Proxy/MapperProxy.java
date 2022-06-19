package com.itheima.mybatis.sqlsession.Proxy;

import com.itheima.mybatis.Utils.Executor;
import com.itheima.mybatis.cfg.Mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取方法名
        String methodName = method.getName();
        //获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className + "." + methodName;
        System.out.println("hello");
        //获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new Exception("传入参数有误");//什么是runtime异常
        }
        //Executor为核心代码块，其中得selectList实现了数据的库的查询
        return new Executor().selectList(mapper, conn);
    }
}
