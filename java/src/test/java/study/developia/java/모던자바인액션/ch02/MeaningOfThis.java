package study.developia.java.모던자바인액션.ch02;

import org.junit.jupiter.api.Test;

public class MeaningOfThis {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    @Test
    void test() {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt(); // 5
    }

}
