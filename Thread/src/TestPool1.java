import java.util.concurrent.TimeUnit;

public class TestPool1 {
    public static void main(String[] args) {
/*        ThreadPool threadPool1 = new ThreadPool1(1,
                1000, TimeUnit.MILLISECONDS, 1,
                (queue, task)->{
            // 1. 死等
//            queue.put(task);
            // 2) 带超时等待
//            queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            // 3) 让调用者放弃任务执行
//            log.debug("放弃{}", task);
            // 4) 让调用者抛出异常
//            throw new RuntimeException("任务执行失败 " + task);
            // 5) 让调用者自己执行任务
            task.run();
        });*/
        ThreadPool threadPool1 = new ThreadPool(5, 2000, TimeUnit.MILLISECONDS, 3, (queue, task) -> {
            queue.offer(task, 1000, TimeUnit.MILLISECONDS);
        });
        for (int i = 0; i < 13; i++) {
            int j = i;
            threadPool1.execute(() -> {
                try {
                    Thread.sleep(2000L);
                    System.out.println("运行了" + j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                System.out.println(j);
            });
        }
    }
}
