package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class handle implements InvocationHandler {
    Object target=null;
    handle(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("run")){
            System.out.println("this is dogone");

            method.invoke(target,args);

            System.out.println("dogone stopped");

        }
        if(method.getName().equals("sleep")){

            System.out.println("this is dogone");

            method.invoke(target,args);//调用target的method使用参数args

            System.out.println("dogone wakes up");
        }

        return null;
    }
}
