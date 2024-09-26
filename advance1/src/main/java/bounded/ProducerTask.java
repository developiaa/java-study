package bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable {
    private BoundedQueue boundedQueue;
    private String request;

    public ProducerTask(BoundedQueue boundedQueue, String request) {
        this.boundedQueue = boundedQueue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산 시도] " + request + "->" + boundedQueue);
        boundedQueue.put(request);
        log("[생산 완료] " + request + "->" + boundedQueue);
    }
}
