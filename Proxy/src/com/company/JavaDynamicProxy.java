package com.company;

import java.lang.reflect.Proxy;

/*
* 动态代理案例
* */
public class JavaDynamicProxy {
    public static void main(String[] args) {
        JavaDeveloper zack= new JavaDeveloper("zack");


        Developer zackProxy= (Developer) Proxy.newProxyInstance(zack.getClass().getClassLoader(),
                zack.getClass().getInterfaces(),(proxy, method, agrs) -> {
                    if(method.getName().equals("code")){
                        System.out.println("zack is praying for the code!");
                        return method.invoke(zack,agrs);//调用原有函数
                    }
                    if(method.getName().equals("debug")){
                        System.out.println("zack's code have no bug!No need to debug!");
                        return null;
                    }
                    return null;
                });
        zackProxy.code();
        zackProxy.debug();
    }
}
