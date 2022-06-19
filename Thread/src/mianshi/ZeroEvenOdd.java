package mianshi;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private volatile int n;
    static  volatile int i=0;
    static volatile int nexttorun=0;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i!=n){
            while(i!=n&&nexttorun!=0){
                Thread.yield();
            }
            if(i!=n)
                printNumber.accept(0);
            nexttorun=(i%2==1)?2:1;
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(i!=n){
            while(i!=n&&nexttorun!=2){
                Thread.yield();
            }
            if(i!=n)
                printNumber.accept(++i);
            nexttorun=0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i!=n){
            while(i!=n&&nexttorun!=1){
                Thread.yield();
            }
            if(i!=n)
                printNumber.accept(++i);
            nexttorun=0;
        }

    }


    static class intConsumer implements IntConsumer{

        @Override
        public void accept(int value) {
            System.out.println(Thread.currentThread().getName()+""+value);
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new intConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"zero").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new intConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"even").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new intConsumer());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"odd").start();
    }
}