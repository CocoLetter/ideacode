import java.util.concurrent.locks.LockSupport;

class MyThread12 extends Thread {
    private Object object;

    public MyThread12(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

        System.out.println("after unpark");
    }
}

public class test1213 {
    public static void main(String[] args) {
        MyThread12 myThread = new MyThread12(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        Object o = new Object();
        // 获取许可
        LockSupport.park(o);
        System.out.println("after park");
    }
}

