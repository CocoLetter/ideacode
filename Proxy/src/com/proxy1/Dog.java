package com.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Dog {
    void run();
    void sleep();
}


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
