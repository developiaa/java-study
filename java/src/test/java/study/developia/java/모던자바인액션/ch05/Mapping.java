package study.developia.java.모던자바인액션.ch05;

import org.junit.jupiter.api.Test;
import study.developia.java.모던자바인액션.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class Mapping {
    List<String> words = Arrays.asList("Hello", "World");

    @Test
    void test1() {
        List<String> list = Dish.menu.stream()
                .map(Dish::getName)
                .toList();

        assertThat(list.size()).isEqualTo(Dish.menu.size());
    }

    @Test
    void test2() {
        List<Integer> list = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();

        System.out.println(list);
        assertThat(list.size()).isEqualTo(Dish.menu.size());
    }

    @Test
    void test3() {
        List<String> list = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        System.out.println(list);
    }

    @Test
    void test4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> list1 = list.stream()
                .map(i -> i * i)
                .toList();

        System.out.println(list1);
    }

    @Test
    void test5() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> list = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .toList();

        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    void test6() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> list = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .toList();

        for (int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
