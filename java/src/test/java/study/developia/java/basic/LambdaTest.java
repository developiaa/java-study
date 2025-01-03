package study.developia.java.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaTest {
    @Test
    void test() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = 0;
        // 컴파일 에러
//        intList.stream().forEach(n -> sum += n);

        System.out.println("sum : " + sum);
    }

    Function<Integer, Integer> function;

    @Test
    void test2() {
        LambdaTest test = new LambdaTest();
        Integer run = test.run();
        Integer apply = test.function.apply(20);

        Assertions.assertThat(run).isEqualTo(20);
        Assertions.assertThat(apply).isEqualTo(30);
    }


    private Integer run() {
        int n = 10;
        Function<Integer, Integer> c = i -> (i + n);
        this.function = c;
        return c.apply(10);
    }

}
