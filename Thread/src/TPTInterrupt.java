/*
class TPTInterrupt {
    private Thread thread;

    public void start() {
        thread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("将结果保存");
                } catch (InterruptedException e) {
                    current.interrupt();
                }
// 执行监控操作
            }
        }, "监控线程");
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }
}


*/
/**
 * TPTInterrupt t = new TPTInterrupt();
 * t.start();
 * Thread.sleep(3500);
 * log.debug("stop");
 * t.stop();
 * <p>
 * 11:49:42.915 c.TwoPhaseTermination [监控线程] - 将结果保存
 * 11:49:43.919 c.TwoPhaseTermination [监控线程] - 将结果保存
 * 11:49:44.919 c.TwoPhaseTermination [监控线程] - 将结果保存
 * 11:49:45.413 c.TestTwoPhaseTermination [main] - stop
 * 11:49:45.413 c.TwoPhaseTermination [监控线程] - 料理后事
 */
