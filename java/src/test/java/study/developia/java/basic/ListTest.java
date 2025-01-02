package study.developia.java.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList set 허용, null 허용, 수정 불가
 * List.of set 불가, null 불가, 수정 불가
 */
public class ListTest {
    @Test
    void changeTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> list2 = List.of(1, 2, 3);

        Assertions.assertThatThrownBy(() -> list.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
        Assertions.assertThatThrownBy(() -> list2.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void setTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.set(0, 99);

        List<Integer> list2 = List.of(1, 2, 3);

        Assertions.assertThat(list.get(0)).isEqualTo(99);
        Assertions.assertThatThrownBy(() -> list2.set(0, 99))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void nullTest() {
        List<Integer> list = Arrays.asList(1, 2, null);

        Assertions.assertThatCode(() -> list.set(0, 99)).doesNotThrowAnyException();
        Assertions.assertThatThrownBy(() -> List.of(1, 2, null))
                .isInstanceOf(NullPointerException.class);
    }
}
