import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    static Random r = new Random();
    final int k = r.nextInt(10);
    static final int k2 = r.nextInt(10);



    public void method0(){
            method1();
    }

    public void method1() {
            method2();
    }

    private void method2() {

        try {
            System.out.println(2 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("heheh");
    }

    public static void main(String[] args)  {
//        Test t1 = new Test();
//        System.out.println("k="+t1.k+" k2="+t1.k2);
//        Test t2 = new Test();
//        System.out.println("k="+t2.k+" k2="+t2.k2);
//
//        ReentrantLock reentrantLock = new ReentrantLock(true);
//        reentrantLock.lock();
//        reentrantLock.unlock();
//        Semaphore semaphore = new Semaphore(12);
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        semaphore.release();
//
////        FutureTask futureTask = new FutureTask();
//
//
//        Thread thread = new Thread();
//
////        BlockingQueue haid= new ArrayBlockingQueue();

        Test test = new Test();

        test.method0();


        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        System.out.println(scanner.ioException());





    }

}

