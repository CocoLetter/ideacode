package com.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class handle implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("run")){
            System.out.println("this is dogone");

            System.out.println("dogone stopped");

        }
        if(method.getName().equals("sleep")){

            System.out.println("this is dogone");

            System.out.println("dogone wakes up");
        }

        return null;
    }
}
