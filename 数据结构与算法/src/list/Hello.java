package list;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Hello {

    Integer name;
    Hello(Integer name){
        this.name=name;
    }

    public static void main(String[] args) {
        System.out.println((-10)%7);
        LinkedList linkedList = new LinkedList();

        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add("String");
        concurrentLinkedQueue.add("String1");
        concurrentLinkedQueue.poll();
        concurrentLinkedQueue.size();
        System.out.println(concurrentLinkedQueue);
    }




}
