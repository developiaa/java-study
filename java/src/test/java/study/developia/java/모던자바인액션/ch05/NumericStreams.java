package study.developia.java.모던자바인액션.ch05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NumericStreams {


    @Test
    void test() {
        IntStream intStream = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0);
        assertThat(intStream.count()).isEqualTo(50);
    }

    @Test
    void test2() {
        IntStream intStream = IntStream.range(1, 100)
                .filter(i -> i % 2 == 0);
        assertThat(intStream.count()).isEqualTo(49);
    }

    // 피타고라스 수
    @Test
    void test3() {
        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(
                        a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        stream.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        /**
         * 3, 4, 5
         * 5, 12, 13
         * 6, 8, 10
         * 7, 24, 25
         * 8, 15, 17
         */
    }

    // 피타고라스 수 개선
    @Test
    void test4() {
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(
                        a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0) // 세번째 수는 정수여야 함
                )
                .limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    void test5() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        assertThat(sum).isEqualTo(41);
    }

    @Test
    void test6() {
        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/Users/developia/dev/study/java-study/java/src/test/java/study/developia/java/모던자바인액션/ch05/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWords);
        assertThat(uniqueWords).isEqualTo(3);
    }

    // 피보나치 수
    @Test
    void test7() {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
        System.out.println();
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(t-> t[0])
                .forEach(System.out::println);
    }

    @Test
    void test8() {
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        // 위와 같지 않다. 끝나지 않음
//        IntStream.iterate(9, n -> n + 4)
//                .filter(n-> n<100)
//                .forEach(System.out::println);

        // 위와 같음
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
        ;
    }

    @Test
    void test9() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }


}
