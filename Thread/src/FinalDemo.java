import java.util.concurrent.atomic.AtomicInteger;

public class FinalDemo {
    private int a;  //普通域
    private final int b; //final域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1; // 1. 写普通域
        b = 2; // 2. 写final域
    }

    public static void writer() {
        finalDemo = new FinalDemo();
    }

    public static void reader() {
        FinalDemo demo = finalDemo; // 3.读对象引用
        int a = demo.a;    //4.读普通域
        int b = demo.b;    //5.读final域
    }

    public static void main(String[] args) {

        FinalDemo finalDemo = new FinalDemo();
        System.out.println(finalDemo.a);
        System.out.println(FinalDemo.finalDemo);
        finalDemo.writer();
        System.out.println(FinalDemo.finalDemo);
        System.out.println(FinalDemo.finalDemo);
        AtomicInteger atomicInteger = new AtomicInteger();
    }
}
