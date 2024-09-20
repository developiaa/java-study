package volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");
        log("runFlag = " + myTask.runFlag);
        thread.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        myTask.runFlag = false;
        log("runFlag = " + myTask.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        // boolean runFlag = true;

        /**
         * 캐시 메모리를 무시하고 메인 메모리에 직접 접근
         * 여러 스레드에서 같은 값을 읽고 써야하는 경우 사용
         * 캐시 메모리보단 성능이 느리다는 단점이 있으므로 반드시 사용할 곳에 사용해야 함
         */
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false로 변하면 탈출

                /**
                 * 안에 어떤 코드를 넣게 되면 컨텍스트 스위칭이 발생되어
                 * 캐시 메모리를 지우기 때문에 volatile 없이도 종료될 수 있다.
                 * 단, 컨텍스트 스위칭이 발생되더라도 캐시 메모리를 지우는 것을 보장하지 않는다.
                 */
            }
            log("task 종료");
        }
    }
}
