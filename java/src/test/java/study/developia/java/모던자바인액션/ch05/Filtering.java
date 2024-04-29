package study.developia.java.모던자바인액션.ch05;

import org.junit.jupiter.api.Test;
import study.developia.java.모던자바인액션.ch04.Dish;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class Filtering {
    List<Dish> specialMenu = Arrays.asList(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER));
    @Test
    void test1() {
        List<Dish> list = specialMenu.stream()
                .filter(d -> d.getCalories() < 320)
                .toList();

        List<Dish> list1 = specialMenu.stream()
                .takeWhile(d -> d.getCalories() < 320)
                .toList();

        assertThat(list.size()).isEqualTo(list1.size());
    }

    @Test
    void test2() {
        List<Dish> list = specialMenu.stream()
                .dropWhile(d -> d.getCalories() < 320)
                .toList();

        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void test3() {
        List<Dish> list = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .toList();

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0).getCalories()).isEqualTo(530);
    }

    @Test
    void test4() {
        List<Dish> list = specialMenu.stream()
                .filter(d -> d.getType().equals(Dish.Type.MEAT))
                .limit(2)
                .toList();

        assertThat(list.size()).isEqualTo(1);
    }
}
