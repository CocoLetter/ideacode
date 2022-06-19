public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("开始时间"+System.currentTimeMillis());
//        myThread.join(1000);
        System.out.println("开始时间"+System.currentTimeMillis());

    }
}
