package start;

import static util.MyLogger.log;

public class HelloRunnable implements Runnable{
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + ": run()");
        log("runnable() run()");
    }
}
