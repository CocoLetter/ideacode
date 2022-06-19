package 有限状态机;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.text.Collator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;


class compare{

    public static void main(String[] args) {
        PriorityQueue<String> strings = new PriorityQueue<>();
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        queue.add(2);
        queue.add(1);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
//        queue.;(System.out::println);
        String a = "12324";
        String b = "23248";
//        System.out.println(a.compareTo("擦"));
//        System.out.println(a.compareTo("啊"));
        System.out.println(a.compareTo(b));

    }
}