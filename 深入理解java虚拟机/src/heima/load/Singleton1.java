package heima.load;
//线程安全的懒汉式单例模式
public class Singleton1 {
    private Singleton1() {
    }

    private static class SingleHolder {
        private final static Singleton1 SINGLETON = new Singleton1();
    }

    public static Singleton1 getInstance() {
        return SingleHolder.SINGLETON;
    }
}
