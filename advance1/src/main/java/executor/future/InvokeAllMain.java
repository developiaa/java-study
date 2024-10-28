package executor.future;

import executor.CallableTask;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class InvokeAllMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);
        List<CallableTask> taskList = List.of(task1, task2, task3);
        List<Future<Integer>> futures = executorService.invokeAll(taskList);
        for (Future<Integer> future : futures) {
            Integer value = future.get();
            log("value = " + value);
        }
        executorService.close();
    }

}