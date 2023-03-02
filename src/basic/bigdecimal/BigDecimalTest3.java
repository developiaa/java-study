package basic.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest3 {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2");

        // BigDecimal to int
        int i = a.intValue();
        System.out.println("i = " + i);

        // BigDecimal to long
        long l = a.longValue();
        System.out.println("l = " + l);

        // BigDecimal to float
        float v = a.floatValue();
        System.out.println("v = " + v);

        // BigDecimal to double
        double v1 = a.doubleValue();
        System.out.println("v1 = " + v1);

        // BigDecimal to String
        String s = a.toString();
        System.out.println("s = " + s);

    }
}
