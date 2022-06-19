package mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Answer {

    static ReentrantLock lock =new ReentrantLock();
    static Condition condition1=lock.newCondition();
    static Condition condition2=lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    try {
                        condition1.await();
                        condition2.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println((char) ('A' + i));

                }
            } finally {
                lock.unlock();
            }


        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.println(i + 1);
                    try {
                        condition1.signal();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }).start();
    }
}
