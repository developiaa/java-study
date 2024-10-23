package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static executor.ExecutorUtils.printState;

public class PreStartPoolMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        printState(es);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) es;
        // 부하가 큰 서버일 경우에 서버 시작하자마자 스레드가 필요한 경우 미리 생성해둔다.
        poolExecutor.prestartAllCoreThreads();
        printState(es);
    }
}
