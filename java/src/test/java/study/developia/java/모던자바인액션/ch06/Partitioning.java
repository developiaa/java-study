package study.developia.java.모던자바인액션.ch06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static study.developia.java.모던자바인액션.ch06.Dish.menu;

public class Partitioning {
    @Test
    void test1() {
        Map<Boolean, List<Dish>> collect = menu.stream().collect(partitioningBy(Dish::isVegetarian));

        List<Dish> trueDish = menu.stream().filter(Dish::isVegetarian).toList();
        List<Dish> falseDish = menu.stream().filter(dish -> !dish.isVegetarian()).toList();
        assertThat(collect.get(true)).hasSize(4);
        assertThat(collect.get(false)).hasSize(5);

        assertThat(collect.get(true)).isEqualTo(trueDish);
        assertThat(collect.get(false)).isEqualTo(falseDish);
    }

    @Test
    void test2() {
        Map<Boolean, Dish> collect = menu.stream().collect(
                partitioningBy(
                        Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)
                )
        );
        System.out.println(collect);
    }


    @Test
    void test3() {
        boolean b = IntStream.range(2, 100)
                .noneMatch(i -> 100 % i == 0);

        assertThat(b).isFalse();
    }

    @Test
    void test4() {
        Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(10);
        System.out.println(booleanListMap);
    }

    private Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(this::isPrime));
    }

    private boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }


}
