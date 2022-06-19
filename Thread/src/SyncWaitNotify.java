class SyncWaitNotify {
    private int flag;
    private int loopNumber;

    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag, int nextFlag, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1,4);

        Thread thread1 = new Thread(()->{
            syncWaitNotify.print(1,2,"AA");
        });
        Thread thread2 = new Thread(()->{
            syncWaitNotify.print(2,3,"BB");
        });
        Thread thread3 = new Thread(()->{
            syncWaitNotify.print(3,1,"CC");
        });
        thread1.start();
        thread2.start();
        thread3.start();


    }
}