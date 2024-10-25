package executor.poolsize;

import executor.RunnableTask;

import java.util.concurrent.*;

import static executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV3 {
    public static void main(String[] args) {
        // 기본 스레드를 사용하지 않고, 60초 생존주기를 가진 초과 스레드만 사용
        // 초과 스레드의 수는 제한이 없다.
        // 큐에 작업을 저장하지 않고 바로 받아서 처리한다.
        ExecutorService es = Executors.newCachedThreadPool();
//        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3,
//                TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 100; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
    }
}
