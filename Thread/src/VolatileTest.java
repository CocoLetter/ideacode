import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class VolatileTest {
    static boolean flag=true;

    public static void main(String[] args) {
/*        new Thread(()->{
            while(flag){
                System.out.println(System.currentTimeMillis());
            }
        }).start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=false;
        System.out.println("主线程结束");*/

        IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return 0;
            }
        };

        AtomicInteger balance = new AtomicInteger(10000);
        balance.compareAndSet(10000,12);
        System.out.println(balance.toString());

    }
}



