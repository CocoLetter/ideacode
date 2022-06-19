import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Code_ConcurrentLinkedQueue {


    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("1");
        queue.add("1");
        System.out.println(queue);
        queue.offer("2");
        queue.offer("2");
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.remove("2");
        System.out.println(queue);



    }
}
