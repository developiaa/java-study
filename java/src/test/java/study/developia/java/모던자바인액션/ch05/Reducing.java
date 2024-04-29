package study.developia.java.모던자바인액션.ch05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class Reducing {
    @Test
    void test1() {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
        Integer reduce1 = numbers.stream().reduce(0, Integer::sum);
        assertThat(reduce).isEqualTo(15);
        assertThat(reduce1).isEqualTo(15);


        Integer reduce2 = numbers.stream().reduce(0, Integer::max);
        assertThat(reduce2).isEqualTo(5);

        Optional<Integer> reduce3 = numbers.stream().reduce(Integer::min);
        assertThat(reduce3).isEqualTo(Optional.of(1));
    }
}
