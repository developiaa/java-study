package study.developia.java.함수형_프로그래밍_with_자바.chapter6;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ch6Test {
    @Test
    void test1() {
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);


        var strings = List.of("a", "b", "c", "d", "e", "f", "g");

        String reduce1 = strings.stream().reduce("", String::concat);
        System.out.println("reduce1 = " + reduce1);


        String collect = strings.stream().collect(Collector.of(() -> new StringJoiner(""),
                StringJoiner::add, StringJoiner::merge, StringJoiner::toString));

        System.out.println("collect = " + collect);

        String collect1 = strings.stream().collect(Collectors.joining());
        System.out.println("collect1 = " + collect1);
    }

    @Test
    void test2() {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 1);

        List<Integer> list = numbers.stream().takeWhile(number -> number < 4).toList();
        System.out.println("list = " + list);

        List<Integer> list1 = numbers.stream().dropWhile(number -> number < 4).toList();
        System.out.println("list1 = " + list1);
    }


}
