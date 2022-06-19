import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

interface RejectPolicy1<T>{
    void reject(BlockingQueue1<T> queue, T task);
}


class ThreadPool1 {
    //任务队列
    private BlockingQueue1<Runnable> taskQueue;

    private HashSet<Worker> workers = new HashSet<>();

    private int coreSize;

    private long timeout;

    private TimeUnit timeUnit;
    private RejectPolicy1<Runnable> rejectPolicy;
    int i=0;

    public void execute(Runnable task){
        synchronized(workers){
            if(workers.size()<coreSize){
                Worker worker =new Worker(task);
                workers.add(worker);
                worker.start();
            }else{
//                taskQueue.put(task);
                taskQueue.tryput(task,rejectPolicy);
                System.out.println("taskQueue.tryput(task,rejectPolicy);"+ ++i);

            }

        }
    }

    public ThreadPool1(int coreSize, long timeout, TimeUnit timeUnit,int queueSize,RejectPolicy1<Runnable> rejectPolicy){
        this.coreSize=coreSize;
        this.timeout=timeout;
        this.timeUnit=timeUnit;
        this.taskQueue=new BlockingQueue1<>(queueSize);
        this.rejectPolicy=rejectPolicy;
    }


    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task){
            this.task=task;
        }

        public void run(){
            while(task!=null || (task=taskQueue.poll(timeout,timeUnit))!=null){
                try{
                    task.run();
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    task=null;
                }
            }
            synchronized(workers){
                System.out.println("从workers中移除worker" + this);
                workers.remove(this);
            }
        }
    }

}



class BlockingQueue1<T> {
    //任务队列
    private Deque<T> queue=new ArrayDeque<>();
    //锁
    private ReentrantLock lock=new ReentrantLock();

    private Condition fullWaitSet=lock.newCondition();

    private Condition emptyWaitSet=lock.newCondition();

    private int capacity;

    public BlockingQueue1(int capacity){
        this.capacity=capacity;
    }

    public void tryput(T task,RejectPolicy1 rejectPolicy){
        lock.lock();
        try{
            if(queue.size()==capacity){
                System.out.println("满了");
                rejectPolicy.reject(this, task);
            }else{
                System.out.println("没有满直接添加");
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        }finally{
            lock.unlock();
        }
    }


    public boolean offer(T task,TimeUnit unit, long timeout){
        lock.lock();
        System.out.println("offer进入锁"+System.currentTimeMillis());
        try {
            long nanos = unit.toNanos(timeout);
//            nanos = 500;
            while(queue.size()==capacity){
                try {
                    if(nanos<=0){
                        System.out.println("时间到，取消任务"+task);
                        return false;
                    }
                    System.out.println("等待进入队列");
                    nanos=fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        }finally{
            lock.unlock();
        }


    }

    public void put(T task){
        lock.lock();

        try {
            while(queue.size()==capacity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            emptyWaitSet.signal();
        }finally{
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while(queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }


    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while(queue.isEmpty()){
                try {
                    if(nanos<=0)
                        return null;
                    nanos=emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }






    public int size(){
        lock.lock();
        try {
            return queue.size();
        }finally{
            lock.unlock();
        }
    }

}
