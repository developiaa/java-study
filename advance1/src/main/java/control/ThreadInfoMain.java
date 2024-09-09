package control;

import start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        // 메인 스레드
        Thread thread = Thread.currentThread();
        log("mainThread = " + thread);
        log("mainThread.threadId() = " + thread.threadId());
        log("mainThread.getName() = " + thread.getName());
        log("mainThread.getPriority() = " + thread.getPriority());
        log("mainThread.getThreadGroup() = " + thread.getThreadGroup());
        log("mainThread.getState() = " + thread.getState());

        // 메인 스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("mainThread = " + myThread);
        log("mainThread.threadId() = " + myThread.threadId());
        log("mainThread.getName() = " + myThread.getName());
        log("mainThread.getPriority() = " + myThread.getPriority());
        log("mainThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("mainThread.getState() = " + myThread.getState());
    }
}
