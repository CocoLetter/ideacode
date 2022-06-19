package chapter12;

import org.junit.jupiter.api.Test;

public class Stringtest {
    public static void main(String[] args) {
        String a="a"+"b"+"c";
        String b="abc";
        System.out.println(a==b);
    }
    @Test
    public void test(){
        String a="a";
        String b="b";
        String c=a+b;
    }

    @Test
    public void test2(){
        String a =new String("ab");
    }
    @Test
    public void test3(){
        String s = new String("a") + new String("b");
    }
}















