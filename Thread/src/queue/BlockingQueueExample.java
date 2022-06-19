package queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueueExample {
 
    public static void main(String[] args) throws Exception {

        SynchronousQueue queue = new SynchronousQueue();
        System.out.println(queue.offer("1"));
 

    }
}


class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(System.currentTimeMillis());
            Thread.sleep(3467);
            queue.put("12");
            queue.add("1");
            System.out.println("put(1)"+System.currentTimeMillis());
            Thread.sleep(1000);
            queue.put("2");
            System.out.println("put(2)"+System.currentTimeMillis());
            Thread.sleep(1000);
            queue.put("3");
            System.out.println("put(3)"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take()+" "+System.currentTimeMillis());
            Thread.sleep(1202);
            System.out.println(queue.take()+" "+System.currentTimeMillis());
            Thread.sleep(2323);
            System.out.println(queue.take()+" "+System.currentTimeMillis());
            Thread.sleep(1223);
            System.out.println(queue.take()+" "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}