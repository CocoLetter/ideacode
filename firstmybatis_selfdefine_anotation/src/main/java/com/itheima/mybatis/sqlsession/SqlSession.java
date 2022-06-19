package com.itheima.mybatis.sqlsession;


/*
* 自定义Mybatis中和数据交互的核心类
* 里面创建dao接口的代理对象
* */
public interface SqlSession {
    /*
    * 根据daoInterfaceClass dao的接口字节码创建一个代理对象
    * */

    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
