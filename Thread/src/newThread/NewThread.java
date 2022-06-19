package newThread;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread()");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            }
        };


        class MyCallable implements Callable<String> {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Callable<String>";
            }
        }

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyCallable());
        Thread thread2 = new Thread(stringFutureTask);
        thread2.start();
        String s = null;
        try {
            s = stringFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);


        MyThread myThread = new MyThread();
//        myThread.start();


//        thread.start();


        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(runnable);
//        thread1.start();


    }
}
