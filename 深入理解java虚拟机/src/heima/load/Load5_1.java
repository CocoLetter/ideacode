package heima.load;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Load5_1 {
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
Class<?> aClass = Class.forName("heima.load.F");
System.out.println(aClass.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
    Method croar = F.class.getMethod("croar");
    croar.invoke(null);


}


}


