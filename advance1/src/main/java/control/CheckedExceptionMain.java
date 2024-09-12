package control;

import static util.ThreadUtils.*;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() {
            /**
             * try catch 없이 예외를 던질 수 없다.
             * 부모 메서드가 체크 예외를 던지지 않을 경우 재정의 된 자식 메서드도 체크 예외를 던질 수 없다.
             * 자식 메서드는 부모 메서드가 던질 수 있는 예외의 하위 타입만 던질 수 있다.
             * 런타임 예외는 예외 처리를 강제하지 않으므로 상관없이 던질 수 있다.
             */
            sleep(1000);
        }
    }
}
