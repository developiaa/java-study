package study.developia.java.함수형_프로그래밍_with_자바.chapter7;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chapter7Test {
    @Test
    void test() {
        IntStream.iterate(1, idx -> idx < 10, idx -> idx + 1)
                .forEachOrdered(System.out::println);

        Stream.generate(new AtomicInteger()::incrementAndGet)
                .parallel()
                .limit(1000L)
                .mapToInt(Integer::valueOf)
                .max()
                .ifPresent(System.out::println);
    }

    @Test
    void test2() {
        String[] fruits = new String[]{"apple", "banana", "orange", "pineapple"};

        String[] ps = Arrays.stream(fruits)
                .filter(i -> i.contains("p"))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(ps));
    }

    @Test
    void fileIoTest() {
        Path start = Paths.get("/Users/developia/dev/study/java-study/java/src/main/java/study/developia/java");

        try (var stream = Files.walk(start)) {
            stream.map(Path::toFile)
                    .filter(Predicate.not(File::isFile))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fileIoTest2() {
        Path start = Paths.get("/Users/developia/dev/study/java-study/java/src/main/java/study/developia/java");

        BiPredicate<Path, BasicFileAttributes> mather = (path, attr) -> attr.isDirectory();

        try (var stream = Files.find(start, Integer.MAX_VALUE, mather)) {
            stream.map(Path::toFile)
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void timeTest() {
        Boolean isItTeaTime = LocalDateTime.now()
                .query(temporal -> {
                    LocalDateTime time = LocalDateTime.from(temporal);
                    return time.getMinute() <= 50;
                });


        LocalDateTime time = LocalDateTime.now().query(LocalDateTime::from);
        System.out.println(isItTeaTime);
        System.out.println(time);
        System.out.println(LocalDateTime.now());
    }


}
