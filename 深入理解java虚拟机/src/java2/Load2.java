package java2;

import java.io.IOException;

/**
 * 解析的含义
 */
public class Load2 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        ClassLoader classloader = Load2.class.getClassLoader();
//// loadClass 方法不会导致类的解析和初始化
//        Class<?> c = classloader.loadClass("java2.C");
        Class.forName("java2.C");
// new C();
        System.in.read();
    }
}

class C {
    final static D d=new D();
    static {
        System.out.println("类C被加载了");
    }
    {
        System.out.println("类C被实例化了");
    }
}

class D {
    static {
        System.out.println("类D被初始化了");
    }
    {
        System.out.println("类D被实例化了");
    }

}