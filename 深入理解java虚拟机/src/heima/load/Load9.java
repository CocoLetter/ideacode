package heima.load;

import java.io.IOException;

public class Load9 {
    public static void main(String[] args) throws IOException {
        Singleton.test();
//        Singleton.getInstance();
        System.in.read();
    }

}

class Singleton {
    static{
        System.out.println("Singleton init");
    }
    {
        System.out.println("singleton instance");
    }

    public static void test() {
        System.out.println("test");
    }

    private Singleton() {}

    private static class LazyHolder{
        private static  int S=10;
        private static final Singleton SINGLETON = new Singleton();
        static {
            System.out.println("lazy holder init");
        }
    }

    public static void getInstance() {
        System.out.println(LazyHolder.S);
    }

}