package study.developia.java.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {
    @Test
    void test() {
        String username = null;

        String result1 = Optional.ofNullable(username).orElse(getDefaultName());
        assertThat(result1).isEqualTo("no name");

        String result2 = Optional.ofNullable(username).orElseGet(() -> getDefaultName());
        assertThat(result2).isEqualTo("no name");
    }

    @Test
    void test2() {
        String username = "hello";

        String result = Optional.ofNullable(username).orElse(getDefaultName());
        // 값은 no name이 아니지만 호출은 하기 때문에 getDefaultName call 찍힘
        assertThat(result).isEqualTo("hello");

        String result2 = Optional.ofNullable(username).orElseGet(this::getDefaultName);
        assertThat(result2).isEqualTo("hello");
    }


    private String getDefaultName() {
        System.out.println("getDefaultName call");
        return "no name";
    }
}
