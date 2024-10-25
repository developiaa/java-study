package executor.poolsize;

import executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV2 {
    public static void main(String[] args) {
        // 고정된 풀 사용하여 메모리 리소스가 어느 정도 예측 가능함
        // 큐 사이즈에 제한이 없음
        // 서버 자원은 여유가 있지만 요청이 많아질 경우 점점 느려짐
        ExecutorService es = Executors.newFixedThreadPool(2);
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 10; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es);
        }

        es.close();
        log("== shutdown 완료 ==");
    }
}
