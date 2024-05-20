package study.developia.java.모던자바인액션.ch13;

import org.junit.jupiter.api.Test;

public class Ambiguous {

    @Test
    void test() {
        new C().hello();
    }

    static interface A {

        default void hello() {
            System.out.println("Hello from A");
        }

    }

    static interface B {

        default void hello() {
            System.out.println("Hello from B");
        }

    }

    static abstract class F {
        public void hello() {
            System.out.println("Heel from F");
        }
    }


    static class C implements B, A {

        @Override
        public void hello() {
            //우선순위가 결정되지 않는 경우 오버라이드 해야 한다.
            A.super.hello();
        }

    }
}
