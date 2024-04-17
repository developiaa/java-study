package study.developia.java.모던자바인액션.ch02.apple.동적파라미터화;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BehaviorParameterization {
    @Test
    void test() {
        List<Apple> list = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        List<Apple> filter1 = filter(list, new AppleColorPredicate());
        System.out.println("filter1 = " + filter1);
        List<Apple> filter2 = filter(list, new AppleWeightPredicate());
        System.out.println("filter2 = " + filter2);
    }

    @Test
    void test2() {
        // 간단한 예제
        Runnable r = () -> System.out.println("Hello!");
        r.run();

        // 람다로 거름
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
        List<Apple> greenApples = filter(inventory, (Apple a) -> a.getColor() == Color.GREEN);
        List<Apple> redApples = filter(inventory, (Apple a) -> a.getColor() == Color.RED);
        List<Apple> heavyApples = filter(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(greenApples);
        System.out.println(redApples);
        System.out.println(heavyApples);
    }

    @Test
    void test3() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        // 무게 오름차순
        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

        // [Apple{color=GREEN, weight=80}, Apple{color=RED, weight=120}, Apple{color=GREEN, weight=155}]
        inventory.sort(c);
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
