class TPTVolatile {
    private Thread thread;
    private volatile boolean stop = false;

    public void start() {
        thread = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    if (stop) {
                        System.out.println("连理后事");
                        break;
                    }
                    try {
                        Thread.sleep(12);
                    } catch (InterruptedException e) {
                    }
                }
            }

        });
        thread.start();
    }

    public void stop(){
        this.stop=true;
        thread.interrupt();
    }
}
