package study.developia.java.모던자바인액션.ch06;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;
import static study.developia.java.모던자바인액션.ch06.Dish.menu;

public class Summarizing {
    @Test
    void test1() {
        Long howManyMenus = menu.stream().collect(counting());
        Long howManyMenus2 = menu.stream().count();

        assertThat(howManyMenus).isEqualTo(howManyMenus2);
    }

    @Test
    void test2() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> collect = menu.stream().collect(maxBy(dishCaloriesComparator));
        Optional<Dish> collect2 = menu.stream().max(dishCaloriesComparator);
        assertThat(collect).isPresent();
        assertThat(collect).isEqualTo(collect2);

        Optional<Dish> collect3 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        assertThat(collect).isEqualTo(collect3);

    }

    @Test
    void test3() {
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        int totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();
        assertThat(totalCalories).isEqualTo(4300);
        assertThat(totalCalories).isEqualTo(totalCalories2);

        Integer totalCalories3 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        Integer totalCalories4 = menu.stream().map(Dish::getCalories).reduce(0, (i, j) -> i + j);
        assertThat(totalCalories).isEqualTo(totalCalories3);
        assertThat(totalCalories3).isEqualTo(totalCalories4);
    }

    @Test
    void test4() {
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        OptionalDouble average = menu.stream().mapToDouble(Dish::getCalories).average();
        assertThat(average).isPresent();;
        assertThat(average.getAsDouble()).isEqualTo(avgCalories);
    }

    @Test
    void test5() {
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        assertThat(menuStatistics).isNotNull();
        assertThat(menuStatistics.getCount()).isEqualTo(9);
        assertThat(menuStatistics.getSum()).isEqualTo(4300);
        assertThat(menuStatistics.getMax()).isEqualTo(800);
        assertThat(menuStatistics.getMin()).isEqualTo(120);
        assertThat(menuStatistics.getAverage()).isEqualTo(477.77777777777777);
        System.out.println(menuStatistics);
    }

    @Test
    void test6() {
        String collect = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(collect); // pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
    }


}
