package study.developia.java.string;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StringTokenTest {

    @Test
    void test1() {
        String expression = "100-200*300-500+20"; //60420
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        StringTokenizer stringTokenizer1 = new StringTokenizer(expression, "*-+", true);
        StringTokenizer stringTokenizer2 = new StringTokenizer(expression, "*-+", false);
        while (stringTokenizer1.hasMoreTokens()) {
            list.add(stringTokenizer1.nextToken());
        }

        while (stringTokenizer2.hasMoreTokens()) {
            list2.add(stringTokenizer2.nextToken());
        }
        log.info(String.valueOf(list));
        log.info(String.valueOf(list2));

        assertAll(
                () -> assertThat(list.contains("*")).isTrue(),
                () -> assertThat(list.contains("-")).isTrue(),
                () -> assertThat(list.contains("+")).isTrue(),
                () -> assertThat(list2.contains("*")).isFalse(),
                () -> assertThat(list2.contains("-")).isFalse(),
                () -> assertThat(list2.contains("+")).isFalse()
        );
    }
}
