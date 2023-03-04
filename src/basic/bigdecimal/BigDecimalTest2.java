package basic.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest2 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = BigDecimal.TEN;
        BigDecimal c = new BigDecimal("3");

        // a * b = 20
        System.out.println(a.multiply(b));

        // a - b = -8
        System.out.println(a.subtract(b));

        // a + b = 12
        System.out.println(a.add(b));

        // a / b = 0.2
        System.out.println(a.divide(b));


        // 나머지가 딱 떨어지지 않는 순환소수 인 경우는 에러 발생하기 때문에 올림 조건을 넣어주어야 함
        // Non-terminating decimal expansion; no exact representable decimal result.
//        System.out.println(b.divide(c)); // b / c = 3.33333..
        System.out.println(b.divide(c, RoundingMode.HALF_UP)); // b / c = 3

        // 반올림 자리값 명시
        // 3.333333
        System.out.println(b.divide(c, 6, RoundingMode.HALF_EVEN));

        /**
         * RoundingMode.HALF_EVEN은 기본 반올림 정책으로 금융권에서 사용하는 Bankers Rounding 동일한 알고리즘이다.
         *
         * precision : 왼쪽부터 0이 아닌 수가 시작하는 위치부터 오른쪽 끝까지 0이 아닌 수로 끝나는 위치까지의 총 자리수
         * scale : 전체 소수점 자리수, 소수점 첫째 자리부터 오른쪽부터 0이 아닌 수로 끝나는 위치까지의 총 소수점 자리수
         * (단, 0.00, 0.0의 scale은 모두 1이다)
         * DECIMAL128: 최대 34자리까지 표현 가능한 10진수를 저장할 수 있는 형식
         */


        System.out.println();
        // 소수점 이하 절사
        // 1
        System.out.println(new BigDecimal("1.234567").setScale(0, RoundingMode.FLOOR));

        // 소수점 2자리이하 절사 후 올림
        // 1.3
        System.out.println(new BigDecimal("1.234567").setScale(1, RoundingMode.CEILING));

        // 음수일 경우 소수점 이하만 절사한다.
        // -1
        System.out.println(new BigDecimal("-1.2345670").setScale(0, RoundingMode.CEILING));
        // -2
        System.out.println(new BigDecimal("-1.2345670").setScale(0, RoundingMode.FLOOR));


        // 나눈 후 나머지
        // 1
        System.out.println(b.remainder(c, MathContext.DECIMAL128)); // 전체 자리수를 34자리로

        // 절대값
        // 7
        System.out.println(new BigDecimal("-7").abs());

        // 최대 최소
        System.out.println(a.min(b)); // 2
        System.out.println(a.max(b)); // 10

    }
}
