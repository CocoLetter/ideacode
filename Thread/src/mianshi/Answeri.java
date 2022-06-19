package mianshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.设计一个多线程打印程序，第i个线程只打印i-1数字，比如第1个线程打印数字0，
 * 第2个线程只打印数字1，依次类推。任意给定一个数字序列，比如3382019835830，能够使用该程序打印出来。
 */
//public class Answeri {
//    static class MyThread extends Thread{
//
//        static volatile int index=0;
//        private int num;
//        private String s;
//
//         public MyThread(int num,String s){
//             this.num=num;
//             this.s=s;
//         }
//
//         @Override
//         public void run() {
//             while(index!=-1){
//                 while(index!=-1&&num!=(s.charAt(index)-'0')){
//                     Thread.yield();
//                 }
//                 if(index!=-1){
//                     System.out.println(num);
//                     index=(index+1)==s.length()?(-1):(index+1);
//                 }
//             }
//             System.out.println("线程结束"+num);
//         }
//     }
//
//
//     public static void print(String nums)  {
//        MyThread[] mythreads=new MyThread[10];
//         for(int i=0;i<10;i++){
//             mythreads[i]=new MyThread(i,nums);
//             mythreads[i].start();
//         }
//     }
//
//    public static void main(String[] args) {
//        print("2863823");
//    }
//
//}
//public class Answeri {
//    static class MyThread extends Thread {
//        static volatile ReentrantLock lock = new ReentrantLock();
//        static volatile Condition condition = lock.newCondition();
//        static volatile boolean isStop = false;
//        static private volatile int nextNum = 0;
//        static private int index = 0;
//
//        private volatile int threadnum;
//        private String s;
//
//        public MyThread(int num, String s) {
//            this.threadnum = num;
//            this.s = s;
//        }
//
//        @Override
//        public void run() {
//            lock.lock();
//            while (!isStop) {
//                try {
//                    while (threadnum != (s.charAt(index) - '0')) {
//                        condition.await();
//                        if (isStop)
//                            throw new InterruptedException();
//                    }
//                    System.out.println(threadnum);
//                    index++;
//                    if (index == s.length()) isStop = true;
//                    condition.signalAll();
//                } catch (InterruptedException e) {
//                    System.out.println("线程结束"+threadnum);
//                }
//            }
//            lock.unlock();
//        }
//    }
//
//
//    public static void print(String nums) {
//        MyThread[] mythreads = new MyThread[10];
//        for (int i = 0; i < 10; i++) {
//            mythreads[i] = new MyThread(i, nums);
//            mythreads[i].start();
//        }
//    }
//
//    public static void main(String[] args) {
//        print("2863823");
//    }
//
//}



public class Answeri {
    static class MyThread extends Thread {
        static volatile ReentrantLock lock = new ReentrantLock();
        static volatile Condition condition = lock.newCondition();
        static volatile boolean isStop = false;
        static private int index = 0;

        private volatile int threadnum;
        private String s;

        public MyThread(int num, String s) {
            this.threadnum = num;
            this.s = s;
        }

        @Override
        public void run() {
            lock.lock();
            while (!isStop) {
                try {
                    while (threadnum != (s.charAt(index) - '0')) {
                        condition.await();
                        if (isStop)
                            throw new InterruptedException();
                    }
                    System.out.println(threadnum);
                    index++;
                    if (index == s.length()) isStop = true;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    System.out.println("线程结束"+threadnum);
                }
            }
            lock.unlock();
        }
    }


    public static void print(String nums) {
        MyThread[] mythreads = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            mythreads[i] = new MyThread(i, nums);
            mythreads[i].start();
        }
    }

    public static void main(String[] args) {
        print("2863823");
    }

}
