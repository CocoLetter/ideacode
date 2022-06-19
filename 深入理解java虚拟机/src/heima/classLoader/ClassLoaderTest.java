package heima.classLoader;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();

        Class<?> demo = myClassLoader.loadClass("Demo");
        Class<?> demo3 = myClassLoader.loadClass("Demo");
        System.out.println(demo == demo3);     //true

        MyClassLoader myClassLoader1 = new MyClassLoader();
        Class<?> demo1 = myClassLoader1.loadClass("Demo");
        System.out.println(demo==demo1);        //false

    }

}
