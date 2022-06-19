import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicReference;

public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHHOLD=1000;
    private long start;
    private long end;

    public CountTask(long start, long end){
        this.start=start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long sum=0;
        if(end-start<THRESHHOLD){
            for(long i = start; i<= end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long  step=(end-start)/100;
            ArrayList<CountTask> subTasks=new ArrayList<>();
            long pos = start ;
            for (int i =0; i<100; i++){
                long lastOne = pos + step;
                if(lastOne>end ){
                    lastOne=end;
                }

                CountTask countTask = new CountTask(pos, lastOne);
                pos=lastOne+1;
                subTasks.add(countTask);
                countTask.fork();
            }

            for(CountTask t: subTasks){
                sum+=t.join();
            }
            return sum;




        }
    }

    final static ThreadLocal<String> localVariable = new ThreadLocal<String>();



    public static void main(String[] args) {
/*        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(0, 20000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(countTask);
        Long invoke = forkJoinPool.invoke(countTask);
        System.out.println(invoke);
        Long aLong = null;
        try {
            aLong = submit.get();
            System.out.println(aLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

        localVariable.remove();

        ThreadLocal threadLocal = new ThreadLocal<String>();
        threadLocal.set("hehihe");
        System.out.println(threadLocal.get());


        AtomicReference atomicReference = new AtomicReference();
    }



}
