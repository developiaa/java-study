package basic.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        BigDecimal bigDecimal3 = BigDecimal.TEN;
        System.out.println("bigDecimal = " + bigDecimal); // 0
        System.out.println("bigDecimal2 = " + bigDecimal2); // 1
        System.out.println("bigDecimal3 = " + bigDecimal3); // 10

        // double 타입의 값을 그대로 전달할 경우 이진수의 근사치를 가지게 되어 예상값과 다른 값이 출력된다.
        // 0.01000000000000000020816681711721685132943093776702880859375
        System.out.println(new BigDecimal(0.01));

        // 문자열로 변환하여 출력하게 되는 경우 정상적으로 인식한다.
        // 0.01
        System.out.println(new BigDecimal("0.01"));

        // long이나 double을 사용해야할 경우 valueOf를 사용하면 문자열과 동일하게 인식한다.
        System.out.println(BigDecimal.valueOf(0.01));

        BigDecimal a = new BigDecimal("4.022");
        BigDecimal b = new BigDecimal("4.0220");
        BigDecimal c = new BigDecimal("4.022");
        BigDecimal d = new BigDecimal("4.0223");
        BigDecimal e = new BigDecimal("4.021");

        // 레퍼런스 타입이기 때문에 equals로 비교해야 하고, 소수점 자리 끝까지 값이 일치해야 true를 반환한다.
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // false
        System.out.println(a.equals(c)); // true

        // 값의 비교는 compareTo로 확인할 수 있으며 이때는 소수점 맨 끝의 0은 무시한다.
        // 0일 경우 동일한 값
        // -1일 경우 작은 경우
        // 1일 경우 큰 값
        System.out.println(a.compareTo(b)); // 0
        System.out.println(a.compareTo(c)); // 0
        System.out.println(a.compareTo(d)); // -1
        System.out.println(a.compareTo(e)); // 1

    }
}
