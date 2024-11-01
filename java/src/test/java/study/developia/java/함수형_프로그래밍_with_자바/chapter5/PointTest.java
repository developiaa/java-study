package study.developia.java.함수형_프로그래밍_with_자바.chapter5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    void witherTest() {
        int x = 1;
        int newX = 10;
        Point point = new Point(x, 2);
        System.out.println(point);

        Point newPoint = point.with().x(newX);
        System.out.println(newPoint);

        Assertions.assertNotEquals(point.x(), newPoint.x());
        Assertions.assertEquals(point.y(), newPoint.y());
    }

    @Test
    void builderTest() {
        int x = 1;
        int y = 2;

        Point point = new Point(x,y);
        System.out.println(point);

        Point newPoint = new Point.Builder(point)
                .x(x)
                .y(y)
                .build();

        Assertions.assertEquals(point.x(), newPoint.x());
        Assertions.assertEquals(point.y(), newPoint.y());
    }

}
