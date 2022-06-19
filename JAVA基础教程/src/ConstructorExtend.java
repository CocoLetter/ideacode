import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.awt.desktop.SystemEventListener;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConstructorExtend {//测试子类继承父类的构造函数
    public static void main(String args[]){
/*
//  FatherClass fa = new FatherClass();
//  FatherClass fa1 = new FatherClass(100);
//  SonClass son = new SonClass();
//    SonClass son1 = new SonClass(200);
    new SonClass();
//    son1.fun(2);
        char[] cha={'a',98,99};
        int[] in={1,2,2,3};
        System.out.println(cha);
        System.out.println(in);
        System.out.println(String.valueOf(in));

        Object o=true?1:1.2;
        System.out.println(o);//1.0

        System.out.println("****");
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//null
        StringBuffer sb1 = new StringBuffer(str); //异常
        System.out.println(sb1);//
*/

        //对于自定义类，使用系统类加载器进行加载、

//
//        Class clazz = Person.class;
//
//        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
//        Method[] methods = clazz.getMethods();
//        for(Method m : methods){
//            System.out.println(m);
//        }
//        System.out.println();
//        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        for(Method m : declaredMethods){
//            System.out.println(m);
//        }


        int a=10;
        int b=10;

        method(a,b);

        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    public static void method(int a ,int b){

        PrintStream ps=new PrintStream(System.out){
            @Override
            public void println(String x) {
                if("a=10".equals(x)){
                    x="a=100";
                }
                if("b=10".equals(x))
                    x="b=200";
               super.println(x);
            }
        };
        System.setOut(ps);
    }

    public static void method1(int a ,int b){
        System.out.println("a=100");
        System.out.println("b=200");
        System.exit(0);
    }


    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ConstructorExtend.class.getClassLoader();
        System.out.println(classLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@1b0375b3
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }


    @Test
    public void test2() {
//        Consumer<String> con1 = str -> System.out.println(str);
//        con1.accept("北京");

        System.out.println("*******************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
    }



    @Test
    public void test3(){
        Stream<Integer> stream= Stream.of(1,1,1,3);
        //练习：查询员工表中薪资大于7000的员工信息
        //filter()中是filter(Predicate<? super T> predicate)函数式接口
        stream.filter(i->i>1).forEach(System.out::println);
//        stream.filter(i->i>1).forEach(System.out::println);
        int[] a= {1,2,2,3,4};
//        System.out.println(a[1]);
        Set list=  new HashSet<Integer>();
        Set set1=  new HashSet<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(System.out::println);
        list.forEach(i->set1.add(i));
        list.forEach(set1::add);
        System.out.println(set1);
    }

}


