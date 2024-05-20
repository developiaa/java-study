package study.developia.java.모던자바인액션.ch13;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Intro {
    @Test
    void test1() {
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        // sort는 디폴트 메서드
        // naturalOrder는 정적 메서드
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
