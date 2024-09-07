package start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        new Thread(new PrintWork("A", 1000), "Thread-A").start();
        new Thread(new PrintWork("B", 500), "Thread-B").start();
    }

    static class PrintWork implements Runnable {
        private final String content;
        private final int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(this.content);
                try {
                    Thread.sleep(this.sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
