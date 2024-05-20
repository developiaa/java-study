package study.developia.java.모던자바인액션.ch13;

import org.junit.jupiter.api.Test;

public class Diamond {
    @Test
    void test() {
        new D().hello();
    }

    static interface A {

        public default void hello() {
            System.out.println("Hello from A");
        }

    }

    static interface B extends A {}

    static interface C extends A {}

    static class D implements B, C {}
}
