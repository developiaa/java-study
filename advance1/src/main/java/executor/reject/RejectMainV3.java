package executor.reject;

import executor.RunnableTask;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV3 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2")); // 메인 스레드가 처리
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));

        executor.close();
    }
}
