package com.proxy1;
import java.lang.reflect.Proxy;

/**
 * 是否可以在实现类的情况下之直接使用代理
 */
public class test {
    public static void main(String[] args){

        handle handle = new handle();

        Dog proxy = (Dog) Proxy.newProxyInstance(Dog.class.getClassLoader(), new Class[]{Dog.class}, handle);

        proxy.run();

        proxy.sleep();
    }
}
