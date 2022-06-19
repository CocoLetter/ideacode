package mianshi;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2.共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，一个猴子每次拿3个苹果，
 * 如果剩余的苹果不够猴子每次拿的数量，则2只猴子停止拿苹果，请用java多线程模拟上面的描述，要求性能尽可能高效（
 */
public class Answer2 {

    static AtomicInteger apples = new AtomicInteger(9);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
//                synchronized (Answer2.class) {
                    int oldvalue = apples.get();
                    while (!apples.compareAndSet(oldvalue, oldvalue - 2)) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if ((oldvalue = apples.get()) < 2) break;
                    }
                    System.out.println("-2  " + apples);
                    if (apples.get() < 2) break;
                }
//            }
        }).start();
        new Thread(() -> {
            while (true) {
//                synchronized (Answer2.class){
                    int oldvalue=apples.get();
                    while(!apples.compareAndSet(oldvalue, oldvalue - 3)){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if((oldvalue=apples.get())<3) break;
                    }
                    System.out.println("-3  "+apples);
                    if(apples.get()<3) break;
                }
//            }

        }).start();




    }
}
