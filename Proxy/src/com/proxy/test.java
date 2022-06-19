package com.proxy;

import com.company.Developer;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args){
        //第三个参数为InvocationHandler接口实现类
        //Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handle);

        DogOne dogOne = new DogOne();
        handle handle = new handle(dogOne);

//        Dog proxy = (Dog) Proxy.newProxyInstance(dogOne.getClass().getClassLoader(),dogOne.getClass().getInterfaces(),handle);
        Dog proxy = (Dog) Proxy.newProxyInstance(Developer.class.getClassLoader(), dogOne.getClass().getInterfaces(), handle);
        /**
         * 是否可以在实现类的情况下之直接使用代理
         */
        //这里代理对象也转化为Dog类型这样才能调用被代理对对象的方法
        proxy.run();
        proxy.sleep("hello");

    }
}
