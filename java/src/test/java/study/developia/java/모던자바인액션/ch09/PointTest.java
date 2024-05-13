package study.developia.java.모던자바인액션.ch09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class PointTest {


    @Test
    void testMoveRightBy() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);
        assertThat(15).isEqualTo(p2.getX());
        assertThat(5).isEqualTo(p2.getY());
    }

    @Test
    void test2() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(20, 10);
        // x를 비교하고 y를 비교함
        int result = Point.compareByXAndThenY.compare(point1, point2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void test3() {
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(10, 5), new Point(15, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 5);
        assertThat(expectedPoints).isEqualTo(newPoints);
    }

    static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point moveRightBy(int x) {
            return new Point(this.x + x, this.y);
        }

        public final static Comparator<Point> compareByXAndThenY = Comparator.comparing(Point::getX)
                .thenComparing(Point::getY);

        public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
            return points.stream()
                    .map(p -> new Point(p.getX() + x, p.getY()))
                    .toList();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point point)) return false;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }


}
