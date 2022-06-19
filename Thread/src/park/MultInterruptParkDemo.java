package park;

import java.util.concurrent.locks.LockSupport;

public class MultInterruptParkDemo {
    public static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo04 t4 = new ThreadDemo04();
        t4.start();
        Thread.sleep(1000);
//        t4.interrupt();
//        flag = false;
    }
    public static class ThreadDemo04 extends Thread {
        @Override
        public void run() {
            LockSupport.park();
            System.out.println("本打印出现在第一个park()之后");
//            LockSupport.park();
//            System.out.println("本打印出现在第二个park()之后");
        }
    }
}