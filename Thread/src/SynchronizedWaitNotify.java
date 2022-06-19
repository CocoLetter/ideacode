public class SynchronizedWaitNotify {
    private int flag;
    private int loopNumber;

    SynchronizedWaitNotify(int flag, int loopNumber){
        this.flag=flag;
        this.loopNumber=loopNumber;
    }
    public void print(int waitFlag,int nextWaitFlag,String str){
        for (int i = 0; i <loopNumber ; i++) {
            synchronized(this){
                while(waitFlag!=this.flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(str);
                flag=nextWaitFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        SynchronizedWaitNotify synchronizedWaitNotify = new SynchronizedWaitNotify(1, 4);
        new Thread(()->{
            synchronizedWaitNotify.print(1,2,"A");
        }).start();
        new Thread(()->{
            synchronizedWaitNotify.print(2,3,"B");
        }).start();
        new Thread(()->{
            synchronizedWaitNotify.print(3,1,"C");
        }).start();
    }
}
