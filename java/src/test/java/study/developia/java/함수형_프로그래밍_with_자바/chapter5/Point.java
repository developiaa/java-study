package study.developia.java.함수형_프로그래밍_with_자바.chapter5;

import lombok.With;

public record Point(int x, int y) {
    public With with() {
        return new With(this);
    }

    public record With(Point source) {
        public Point x(int x) {
            return new Point(x, source.y());
        }

        public Point y(int y) {
            return new Point(source.x(), y);
        }
    }

    public static final class Builder {
        private int x;
        private int y;

        public Builder(Point point) {
            this.x = point.x();
            this.y = point.y();
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Point build() {
            return new Point(x, y);
        }
    }
}
