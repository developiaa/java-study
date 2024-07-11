package study.developia.java.함수형_프로그래밍_with_자바.chapter4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    void test() {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal result = bigDecimal.add(BigDecimal.ONE);

        Assertions.assertEquals(bigDecimal, BigDecimal.ONE);
        Assertions.assertNotEquals(result, BigDecimal.ZERO);
    }
}
