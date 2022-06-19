public class DeadLock {


    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {

                    System.out.println("锁住了o2");
                }
                System.out.println("运行完了");
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("t2锁住了o2");

                synchronized (o1) {

                    System.out.println("锁住了o2");
                }
                System.out.println("t2运行完了");
            }
        }, "t2").start();

    }
}



