package study.developia.java.모던자바인액션.ch03;

import org.junit.jupiter.api.Test;
import study.developia.java.모던자바인액션.ch02.apple.동적파라미터화.Apple;
import study.developia.java.모던자바인액션.ch02.apple.동적파라미터화.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Lambda {
    @Test
    void test1() {
        IntPredicate intPredicate = (int i) -> i % 2 == 0;
        System.out.println(intPredicate.test(1000));

        Predicate<Integer> integerPredicate = (Integer i) -> i % 2 != 0;
        System.out.println(integerPredicate.test(1000));
    }

    @Test
    void test2() {
        // 두개는 동일하다.
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();
    }

    @Test
    void test3() {
        // 두개는 동일하다.
        Function<Integer, Apple> c1 = Apple::new;
        Apple a1 = c1.apply(100);

        Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        Apple a2 = c2.apply(200);
    }

    @Test
    void test4() {
        // 두개는 동일하다.
        BiFunction<Integer, Color, Apple> c3 = Apple::new;
        Apple a1 = c3.apply(100, Color.GREEN);

        BiFunction<Integer, Color, Apple> c4 = (weight, color) -> new Apple(weight, color);
        Apple a2 = c4.apply(200, Color.RED);
    }

    @Test
    void test5() {
        interface TriFunction<T, U, V, R> {
            R apply(T t, U u, V v);
        }

        class Color {
            int a;
            int b;
            int c;

            Color(int a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }

        TriFunction<Integer, Integer, Integer, Color> triFunction = Color::new;
        Color apply = triFunction.apply(1, 2, 3);
    }

    @Test
    void test6() {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));
        // 다 같음
        inventory.sort(new AppleComparator());
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing((Apple a) -> a.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    @Test
    void test7() {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        ));
        inventory.sort(
                Comparator.comparing(Apple::getColor)
                        .reversed()
                        .thenComparing(Apple::getColor)
        );
    }

}



