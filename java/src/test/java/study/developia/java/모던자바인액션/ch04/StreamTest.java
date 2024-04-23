package study.developia.java.모던자바인액션.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamTest {
    @Test
    void test1() {
        List<String> list = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .toList();

        Assertions.assertThat(list.size()).isEqualTo(3);
        System.out.println(list);

    }
}
